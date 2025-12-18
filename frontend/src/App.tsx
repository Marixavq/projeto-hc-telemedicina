import { BrowserRouter, Route, Routes } from "react-router-dom"

import Home from "./pages/Home/Home";
import Consultas from "./pages/Consultas/Consultas"
import AnotarConsultas from "./pages/AnotarConsultas/AnotarConsultas";
import Cadastro from "./pages/Cadastro/Cadastro";
import Login from "./pages/Login/Login";
import Integrantes from "./pages/Integrantes/Integrantes";
import Faq from "./pages/Faq/Faq";
import Chat from "./pages/Chat/Chat";
import Contato from "./pages/Contato/Contato";
import Sobre from "./pages/Sobre/Sobre";
import Layout from './components/Layout/Layout'


function App() {

  return (
    <>
      <BrowserRouter>

        <Routes>
          <Route path="/" element={<Layout />}>
            <Route index element={<Home />} />   {/* rotas filhas do layout */}
            <Route path="/Consultas" element={<Consultas />} />

            <Route path="/cadastrar" element={<AnotarConsultas />} />
            <Route path="/atualizar" element={<AnotarConsultas />} />
            {/* <Route path="/listar" element={<Listar />} /> */}
            <Route path="/AnotarConsultas" element={<AnotarConsultas />} />
            <Route path="/Cadastro" element={<Cadastro />} />
            <Route path="/Login" element={<Login />} />
            <Route path="/Integrantes" element={<Integrantes />} />
            <Route path="/Faq" element={<Faq />} />
            <Route path="/Chat" element={<Chat />} />
            <Route path="/Contato" element={<Contato />} />
            <Route path="/Sobre" element={<Sobre />} />
          </Route>
        </Routes>

      </BrowserRouter>

    </>
  )
}

export default App
