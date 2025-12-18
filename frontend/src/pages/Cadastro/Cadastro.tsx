import { useState } from "react";
import { useForm } from "react-hook-form";

import Botao from "../../components/Botao/Botao";
import Titulo from "../../components/Titulo/Titulo";

type CadastroFormInputs = {
  nome: string;
  email: string;
  senha: string;
  confirmarSenha: string;
};

const Cadastro = () => {
  const { register, handleSubmit, watch, formState: { errors }, reset } = useForm<CadastroFormInputs>();

  const senha = watch("senha");

  const [enviado, setEnviado] = useState(false);

  const onSubmit = (data: CadastroFormInputs) => {
    console.log(data);
    setEnviado(true);
    reset();
  };

  return (
    <>
      <div className="bg-[#d9d9d9] flex flex-col space-y-2 p-8 justify-center">
        <Titulo texto="Cadastro" />
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
                <label htmlFor="email" className="text-base lg:text-lg">Email</label>
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
                <label htmlFor="senha">Senha</label>
                <input
                  type="password"
                  id="senha"
                  className="bg-transparent border border-black rounded-sm w-full"
                  {
                  ...register("senha", {
                    required: "A senha é obrigatória!",
                    minLength: { value: 4, message: "Mínimo de 4 caracteres" },
                    validate: value =>
                      !/[A-Z]/.test(value) ? "Deve conter uma letra maiúscula" :
                        !/[a-z]/.test(value) ? "Deve conter uma letra minúscula" :
                          !/\d/.test(value) ? "Deve conter um número" :
                            !/[A-Za-z0-9]/.test(value) ? "Deve conter um caracter especial" :
                              true
                  })
                  }
                />
                {errors.senha && <span className="text-red-500 text-sm" >{errors.senha.message}</span>}
              </div>

              <div>
                <label htmlFor="confirmarSenha">Confirmar Senha</label>
                <input
                  type="password"
                  id="confirmarSenha"
                  className="bg-transparent border border-black rounded-sm w-full"
                  {...register("confirmarSenha", {
                    required: "A confirmação de senha é obrigatória",
                    minLength: { value: 6, message: "Mínimo de 6 caracteres" },
                    validate: (value) =>
                      value === senha || "As senhas não coincidem"
                  })}
                />
                {errors.confirmarSenha && <span className="text-red-500 text-sm">{errors.confirmarSenha.message}</span>}
              </div>

              <div className="flex justify-end">
                <Botao texto="Cadastrar" />
              </div>

              {enviado && <p className="text-green-600 text-center pt-4">Cadastro realizado com sucesso!</p>}
            </fieldset>
          </form>
        </div>
      </div>
    </>
  );
};

export default Cadastro;
