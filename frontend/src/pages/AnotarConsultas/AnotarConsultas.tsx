// import Botao from "../../components/Botao/Botao";
// import Titulo from "../../components/Titulo/Titulo";

// _____API____

import { useState, useEffect } from "react";
import { useNavigate, useLocation } from "react-router-dom";

type Consulta = {
    idConsulta?: number;
    data: string;
    horario: string;
    // recebendo objeto completo pro Java ficar bonito
    especialidade: {
        idEspecialidade: number;
        nomeEspecialidade: string;
        descricao: string;
    };
    profissional: {
        idProfissional: number;
        nomeProfissional: string;
        crmProfissional: string;
    };
};

const AnotarConsulta = () => {
    const navigate = useNavigate();
    const location = useLocation();
    const consultaEdicao = location.state as Consulta | null; // edita consulta, se houver

    const [consulta, setConsulta] = useState<Consulta>({
        idConsulta: consultaEdicao?.idConsulta ?? undefined,
        data: consultaEdicao?.data ?? "",
        horario: consultaEdicao?.horario ?? "",
        // recebendo objeto completo pro Java ficar bonito, mas vou usar só nome
        especialidade: consultaEdicao?.especialidade ?? {
            idEspecialidade: 0,
            nomeEspecialidade: "",
            descricao: "",
        },
        profissional: consultaEdicao?.profissional ?? {
            idProfissional: 0,
            nomeProfissional: "",
            crmProfissional: "",
        },
    });

    // se houver edição, preenche os dados
    useEffect(() => {
        if (consultaEdicao) {
            setConsulta(consultaEdicao);
        }
    }, [consultaEdicao]);

    const API_URL = "http://localhost:8080/consulta";

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        const [parent, child] = name.split(".");

        if (child) {
            // se for filho (atributo do objeto completo)
            setConsulta({
                ...consulta,
                [parent]: {
                    ...consulta[parent as "especialidade" | "profissional"],
                    [child]: value,
                },
            });
        } else {
            // se não, atualiza campo simples
            setConsulta({
                ...consulta,
                [name]: value,
            });
        }
    };


    // Unifica cadastro e atualização
    const handleSubmit = async () => {
        const method = consulta.idConsulta ? "PUT" : "POST";
        const url = API_URL;
        // const url = consulta.idConsulta ? `${API_URL}/${consulta.idConsulta}` : API_URL;
        console.log(consulta)
        try {
            const response = await fetch(url, {
                method,
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(consulta),
            });

            if (response.ok) {
                alert(
                    consulta.idConsulta
                        ? `Consulta atualizada com sucesso!`
                        : `Consulta cadastrada com sucesso!`
                );
                navigate("/consultas");
            } else {
                const erro = await response.text();
                alert("Erro ao salvar consulta: " + erro);
            }
        } catch (error) {
            console.error(error);
            alert("Erro de conexão com o servidor.");
        }
    };

    const handleReset = () => {
        setConsulta({
            idConsulta: 0,
            data: "",
            horario: "",
            especialidade: {
                idEspecialidade: 0,
                nomeEspecialidade: "",
                descricao: "",
            },
            profissional: {
                idProfissional: 0,
                nomeProfissional: "",
                crmProfissional: "",
            },
        });

    };


    // -------- fim  API  ------------
    return (
        <>
            <div className="bg-[#d9d9d9] flex flex-col p- space-y-2 p-8 justify-center">
                {/* <Titulo texto="Anotar Consultas"></Titulo> */}
                <h1 className="text-2xl font-semibold text-center mb-6">
                    {consulta.idConsulta ? "Atualizar Consulta" : "Anotar Consulta"}
                </h1>

                <form
                    id="formConsulta"
                    onReset={handleReset}
                    className="space-y-4">


                    <div className="flex justify-center">

                        <fieldset className="border border-black rounded-lg max-w-72 md:max-w-80 lg:max-w-96 p-6">

                            <p className="text-base text-center pb-4 lg:text-lg">Marque sua consulta no app do HC e anote aqui para ser lembrado.</p>

                            <div className="pb-3">
                                <label htmlFor="data" className="text-base lg:text-lg">Data</label>
                                <input type="date" name="data" id="data" value={consulta.data} onChange={handleChange} className="bg-transparent border border-black rounded-sm w-full" />
                            </div>
                            <div className="pb-3">
                                <label htmlFor="horario" className="text-base lg:text-lg">Horário</label>
                                <input type="time" name="horario" id="horario" value={consulta.horario} onChange={handleChange} className="bg-transparent border border-black rounded-sm w-full" />
                            </div>

                            {/* Ao atualizar, digite uma especialidade já existente no Banco de dados como:  */}
                            {/* Fonoaudiologia  */}
                            <div className="pb-3">
                                <label htmlFor="especialidade.nomeEspecialidade" className="text-base lg:text-lg">Especialidade</label>
                                <input type="text" name="especialidade.nomeEspecialidade" id="especialidade.nomeEspecialidade" value={consulta.especialidade.nomeEspecialidade} onChange={handleChange} className="bg-transparent border border-black rounded-sm w-full" />
                            </div>
                              {/* Ao atualizar, digite um nome já existente no Banco de dados como:  */}
                            {/* Dr. João Silva */}
                            <div className="pb-3">
                                <label htmlFor="profissional.nomeProfissional" className="text-base lg:text-lg">Médico (Profissional)</label>
                                <input type="text" name="profissional.nomeProfissional" id="profissional.nomeProfissional" value={consulta.profissional.nomeProfissional} onChange={handleChange} className="bg-transparent border border-black rounded-sm w-full" />
                            </div>

                            <div className="flex justify-between mt-6">
                                <button
                                    type="button"
                                    onClick={handleSubmit}
                                    className={`${consulta.idConsulta
                                        ? "border border-black bg-orange-300 hover:bg-amber-400"
                                        : "bg-[#417571] border border-black hover:text-black"
                                        } text-white px-5 py-2 rounded-md text-base transition duration-200`}
                                >
                                    {consulta.idConsulta ? "Atualizar" : "Salvar"}
                                </button>

                                <button
                                    type="reset"
                                    className="bg-gray-300 border border-black  hover:bg-gray-400 px-5 py-2 rounded-md text-base transition duration-200"
                                >
                                    Limpar
                                </button>
                            </div>

                        </fieldset>
                    </div>
                </form>
            </div>

        </>
    );
};
export default AnotarConsulta