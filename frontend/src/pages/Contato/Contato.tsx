import { useState } from "react";
import { useForm } from "react-hook-form";

import Botao from "../../components/Botao/Botao";
import Titulo from "../../components/Titulo/Titulo";

type ContatoFormInputs = {
  nome: string;
  email: string;
  mensagem: string;
};

const Contato = () => {
  const { register, handleSubmit, formState: { errors }, reset } = useForm<ContatoFormInputs>();
  const [enviado, setEnviado] = useState(false);

  const onSubmit = (data: ContatoFormInputs) => {
    console.log(data);
    setEnviado(true);
    reset();
  };

  return (
    <>
      <div className="bg-[#d9d9d9] flex flex-col space-y-2 p-8 justify-center">
        <Titulo texto="Contato" />
        <div className="flex justify-center">
          <form onSubmit={handleSubmit(onSubmit)} className="w-full max-w-sm">
            <fieldset className="border border-black rounded-lg p-6 space-y-4">
              <div>
                <label htmlFor="nome">Nome</label>
                <input
                  type="text"
                  id="nome"
                  className="bg-transparent border border-black rounded-sm w-full"
                  {...register("nome", {
                    required: "O nome é obrigatório!"
                  })}
                />
                {errors.nome && <span className="text-red-500 text-sm">{errors.nome.message}</span>}
              </div>

              <div>
                <label htmlFor="email">Email</label>
                <input
                  type="email"
                  id="email"
                  className="bg-transparent border border-black rounded-sm w-full"
                  {...register("email", {
                    required: "O email é obrigatório",
                    pattern: {
                      value: /^[^\s@]+@[^\s@]+\.[^\s@]+$/,
                      message: "Digite um email correto"
                    }
                  })}
                />
                {errors.email && <span className="text-red-500 text-sm">{errors.email.message}</span>}
              </div>

              <div>
                <label htmlFor="mensagem">Mensagem</label>
                <textarea
                  id="mensagem"
                  className="bg-transparent border border-black rounded-sm w-full"
                  {...register("mensagem", {
                    required: "Informe o motivo do contato!"
                  })}
                />
                {errors.mensagem && <span className="text-red-500 text-sm">{errors.mensagem.message}</span>}
              </div>

              <div className="flex justify-end">
                <Botao texto="Enviar" />
              </div>

              {enviado && <p className="text-green-600 text-center pt-4">Mensagem enviada com sucesso!</p>}
            </fieldset>
          </form>
        </div>
      </div>
    </>
  );
};

export default Contato;
