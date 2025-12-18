import Titulo from "../../components/Titulo/Titulo";

import Julia from '../../assets/imagens/julia.jpg';
import Mariana from '../../assets/imagens/mariana.jpg';
import Yanick from '../../assets/imagens/yanick.jpg';


const Integrantes = () => {
    return (
        <>
            <div className="bg-[#d9d9d9] p-8 justify-center">
                <Titulo texto="Integrantes"></Titulo>

                <div className="md:flex justify-center">
                    <div className="flex flex-col md:flex-row justify-between">

                        <div className="py-4 md:px-8 lg:px-10">
                            <img src={Julia} alt="Júlia" className="w-44 h-60 rounded border border-black" />

                            <div className="text-black text-base py-3">
                                <p>Nome: Júlia Tiziotto Buttler</p>
                                <p>RM: 564975</p>
                                <p>Turma: 1TDSA</p>
                                <p>GitHub: <a href="https://github.com/JuliaTButtler">JuliaTButtler</a></p>
                                <p>Linkedin: <a href="https://www.linkedin.com/in/j%C3%BAlia-t-buttler-2b842b367/">Júlia T Buttler</a></p>
                            </div>
                        </div>
                        <div className="py-4 md:p-3 lg:px-6">
                            <img src={Mariana} alt="Mariana" className="w-44 h-60 rounded border border-black" />

                            <div className="text-black text-base py-3">
                                <p>Nome: Mariana Xavier Quispe</p>
                                <p>RM: 566357</p>
                                <p>Turma: 1TDSA</p>
                                <p>GitHub: <a href="https://github.com/Marixavq">Marixavq</a></p>
                                <p>Linkedin: <a href="https://www.linkedin.com/in/mariana-xavier-quispe-095b81305/">Mariana Xavier Quispe</a></p>
                            </div>
                        </div>
                        <div className="py-4 md:p-3 lg:px-6">
                            <img src={Yanick} alt="Yanick" className="w-44 h-60 rounded border border-black" />

                            <div className="text-black text-base py-3">
                                <p>Nome: Yanick José Zen dos Santos</p>
                                <p>RM: 558350</p>
                                <p>Turma: 1TDSA</p>
                                <p>GitHub: <a href="https://github.com/yanick3">yanick3</a></p>
                                <p>Linkedin: <a href="https://www.linkedin.com/in/yanick-santos-8ba750302/">Yanick Santos</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}
export default Integrantes