import Titulo from "../../components/Titulo/Titulo";


const Sobre = () => {
    return (
        <>
            <div className="bg-[#d9d9d9] flex flex-col items-center h-96 space-y-2 p-8">
                <Titulo texto="Sobre o projeto"></Titulo>
                <p className="text-base text-center pb-4 lg:text-lg w-4/5">Nosso projeto tem como objetivo facilitar o uso do aplicativo do Hospital das Clínicas, ajudando pacientes a gerenciar suas consultas de telemedicina de forma simples e eficiente. Através de uma interface intuitiva, o site oferece informações claras sobre agendamentos e cancelamentos, reduzindo o absenteísmo e melhorando a experiência do usuário. Desenvolvido com foco em acessibilidade e praticidade, o projeto une design responsivo e funcionalidades interativas, tornando o cuidado com a saúde mais organizado e acessível a todos.  O site conta com um chatbot que auxilia os usuários a esclarecer dúvidas de forma rápida, um FAQ com perguntas frequentes e um formulário de contato para suporte direto com a equipe do HC.</p>
            </div>
        </>
    );
};

export default Sobre
