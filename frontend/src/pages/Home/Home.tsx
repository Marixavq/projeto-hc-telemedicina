import { Link } from "react-router-dom";

import Titulo from "../../components/Titulo/Titulo";

const Home = () => {
    return (
        <>
            <main>
                <div className="bg-[#d9d9d9] flex flex-col p- space-y-2 p-8 justify-center items-center">

                    <Titulo texto="Seu Guia para as Consultas de Reabilitação Online"></Titulo>

                    <p className="text-base text-center md:text-xl w-3/4 pb-8">Sabemos que participar de consultas online pode parecer complicado. Este site foi criado para te ajudar em cada passo, tornando tudo mais simples e tranquilo.</p>

                    <div className="bg-[#417571] max-w-96 max-h-50 border border-black rounded-xl p-4 md:max-w-md text-center">
                        <h2 className="font-bold text-white self-center text-2xl md:text-3xl">Precisa de ajuda?</h2>
                        <p className="text-white text-center p-2 md:text-lg my-1 ">Conheça SaúdeBot, que vai te guiar na preparação para a consulta e esclarece suas dúvidas.</p>

                        <button className="bg-white border border-black rounded-lg p-2 self-center hover:text-blue-950 transition-colors duration-300 md:p-3 text-xl">
                            <Link to={"/chat"}> {"Clique aqui"}</Link>
                        </button>
                    </div>
                </div>
            </main>
        </>
    );
}
export default Home