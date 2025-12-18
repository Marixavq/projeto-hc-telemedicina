import { Link } from "react-router-dom"
import NavItem from "../NavItem/NavItem"

import imglogo from '../../assets/imagens/imglogo.svg'
import maps from '../../assets/imagens/maps.svg'
import phone from '../../assets/imagens/phone.svg'
import hospital from '../../assets/imagens/hospital.svg'
import playstore from '../../assets/imagens/playstore.svg'


const Footer = () => {
    return (
        <>
            <footer>
                <div className="bg-[#417571] w-full h-auto py-7 md:flex flex-row justify-between">

                    <Link to="/" className="flex items-center justify-center font-joti pl-5 lg:text-xl">
                        <img src={imglogo} alt="Página inicial do site SaúdeBot" className="w-6 h-6" />
                        SaúdeBot
                    </Link>

                    <div className="flex flex-col text-center space-y-2 p-3 md:text-left">
                        <p className="text-2xl font-inter text-white">Projeto</p>
                        <ul>
                            <NavItem to="/consultas" label="Consultas" />
                            <NavItem to="/cadastro" label="Cadastro" />
                            <NavItem to="/login" label="Login" />
                            <NavItem to="/integrantes" label="Integrantes" />
                            <NavItem to="/sobre" label="Sobre" />
                        </ul>
                    </div>

                    <div className="flex flex-col text-center space-y-2 p-3 md:text-left px-6">
                        <p className="text-2xl font-inter text-white">Suporte</p>
                        <ul>
                            <NavItem to="/FAQ" label="FAQ" />
                            <NavItem to="/Chat" label="Chat" />
                            <NavItem to="/Contato" label="Contato" />

                        </ul>
                    </div>

                    <div className="flex flex-col text-center space-y-2 p-3 md:text-left">
                        <p className="text-2xl font-inter text-white">Informações</p>
                        <div className="w-full flex items-center justify-center md:justify-start">
                            <img src={maps} alt="Endereço do Hospital das Clínicas" className="w-6 h-6 pr-1" />
                            <p className="text-white text-base">Complexo do HC – Eixo Rosa (Portão 3, Inrad), São Paulo – SP</p>
                        </div>
                        <div className="w-full flex items-center justify-center md:justify-start">
                            <img src={phone} alt="Telefone para contato com Hospital das Clínicas" className="w-6 h-6 pr-1" />
                            <p className="text-white text-base">(11) 2661-7557 / 2661-7821</p>
                        </div>
                        <div className="w-full flex items-center justify-center md:justify-start">
                            <img src={hospital} alt="Site oficial do Hospital das Clínicas" className="w-6 h-6 pr-1" />
                            <p className="text-white text-base">
                                Site oficial do <a href="https://redelucymontoro.org.br/site/area-do-paciente/teleatendimento/" className="text-black hover:text-blue-950 transition-colors duration-300">HC ImREA</a>
                            </p>
                        </div>
                        <div className="w-full flex items-center justify-center md:justify-start">
                            <img src={playstore} alt="Link da PlayStore para baixar o app Portal do Paciente - HC" className="w-6 h-6" />
                            <p className="text-white text-base">
                                Clique <a href="https://play.google.com/store/apps/details?id=com.netihc.portaldopaciente" className="text-black hover:text-blue-950 transition-colors duration-300">aqui</a> para baixar na PlayStore
                            </p>
                        </div>
                    </div>
                </div>
            </footer>
        </>
    );
};

export default Footer;
