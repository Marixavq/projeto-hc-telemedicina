import Accordion from '../../components/Accordion/Accordion';
import Titulo from "../../components/Titulo/Titulo";
const Faq = () => {
    return (
        <>
            <div className="bg-[#d9d9d9] flex flex-col items-center p- space-y-2 p-8">
                <Titulo texto="FAQ"></Titulo>

                <p className="max-w-xl text-base text-center pb-5 md:text-lg lg:text-xl">
                    Bem vindo(a) a nossa sessão de perguntas frequentes. Caso não encontre a resposta para sua
                    dúvida aqui, acesse a página Chat, ou Contato para falar diretamente com a equipe de suporte.
                </p>


                <Accordion
                    title="Primeiro acesso ao app HC"
                    content={<p>Pesquise "Portal do Paciente HC" na PlayStore ou acesse o <a
                        href="https://play.google.com/store/apps/details?id=com.netihc.portaldopaciente">link</a>
                        para baixar o aplicativo. Clique em <b>Instalar</b> e em <b>Abrir</b>. Nesse
                        primeiro acesso, clique em <b>Cadastrar Senha</b>, cadastre sua senha (guarde a
                        senha pois será importante) e em seguida
                        clique em <b>Localizar Paciente</b>, digite seu CPF (apenas números). Será exibido
                        um nome, se for você prossiga normalmente, senão, clique em <b>Alterar Paciente</b>
                        e você retornará a tela anterior para fazer a busca novamente. Se seu nome estiver
                        correto, preencha com email e número de celular. Selecione o nome completo de sua
                        mãe e seu ano de nascimento. Após a realização dessas etapas, seu cadastro foi
                        concluído com sucesso.
                    </p>}
                />

                <Accordion
                    title="Como recuperar minha senha?"
                    content={<p>Clique no link <b>Esqueci a minha senha</b> e siga o passo a passo indicado nas telas
                        do sistema.
                    </p>}
                />

                <Accordion
                    title="O que eu preciso para participar da teleconsulta?"
                    content={<p>Acesso à Internet; <br />
                        Download do aplicativo Portal do Paciente HC; <br />
                        Cadastro no Portal do Paciente HC; <br />
                        Ter aceito o Termo de Consentimento pelo Portal do Paciente HC; <br />
                        Acesso a um smartphone com câmera frontal (preferencialmente) ou
                        computador/ notebook com webcam; <br />
                        Navegador Google Chrome;</p>}
                />

                <Accordion
                    title="Como acessar minha conta no app HC?"
                    content={<p>Clique no botão <b>Acessar Portal</b>. Digite seu CPF e sua senha cadastrada
                        anteriormente. Clique em <b>Acessar</b>.
                    </p>}
                />

                <Accordion
                    title="Como reagendar minha consulta e/ou exame?"
                    content={<p>O Portal só permite o reagendamento de <b>Consultas</b>. As solicitações de
                        agendamento estão disponíveis apenas para os Institutos: ICHC e IOT. Não é possível
                        solicitar a antecipação da consulta. O sistema não permite reagendamento se teve uma
                        falta seguida da outra.
                    </p>}
                />

                <Accordion
                    title="Os dados do meu cadastro estão desatualizados, como atualizar?"
                    content={<p>Você pode atualizar seus dados diretamente através do portal na opção <b>Meus
                        Dados</b>.
                    </p>}
                />

                <Accordion
                    title="Como entrar na teleconsulta?"
                    content={<p>Clique na opção <b>Teleconsulta</b>. No dia e hora da consulta clique sobre o
                        agendamento. Se esta é a primeira vez que você vai participar de uma teleconsulta
                        será necessário aceitar o
                        Termo de consentimento que aparecerá na tela. Leia o termo e clique no botão
                        <b>SIM</b>, se
                        estiver de acordo com os termos
                        apresentados para participar de uma
                        Teleconsulta.
                        Se não estiver de acordo, clique no botão <b>NÃO</b>. Ao escolher esta opção, você não poderá entrar na consulta. Senão for se
                        seu primeiro acesso, clique em <b>Entrar na Teleconsulta</b>, vai aparecer a
                        mensagem “Aguardando médico entrar”, aguarde. Caso você tenha mais de um navegador
                        instalado, selecione o Google Chrome. Uma janela será exibida perguntando como o
                        paciente
                        gostaria de se juntar ao áudio: clique na opção <b>Microfone</b>. Fale algumas
                        palavras, se ouvir colique no botão verde. Agora, na barra inferior clique no ícone
                        de câmera, clique <b>Permitir</b>, agora você estará visível para seu médico.

                    </p>}
                />
            </div>
        </>
    );
};
export default Faq;