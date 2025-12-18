import { useState } from "react";
import { Link } from "react-router-dom";


import NavItem from "../NavItem/NavItem"

import imglogo from '../../assets/imagens/imglogo.svg'
import menu from '../../assets/imagens/menu.svg'
import x from '../../assets/imagens/x.svg'

const Header = () => {
  const [menuOpen, setMenuOpen] = useState(false);
  return (
    <>
      <header className="z-50 bg-[#417571] w-full flex items-center px-6 lg:px-10 h-24">

        <div className="flex justify-between w-full">
          <Link to="/" className="flex items-center font-joti lg:text-xl">
            <img src={imglogo} alt="Página inicial do site SaúdeBot" className="w-6 h-6" />
            SaúdeBot
          </Link>

          <nav>
            <ul className="hidden md:flex space-x-8">
              <NavItem to="/consultas" label="Consultas" />
              <NavItem to="/faq" label="FAQ" />
              <NavItem to="/chat" label="Chat" />
              <NavItem to="/contato" label="Contato" />
            </ul>
          </nav>

          <div className="absolute right-4 top-7 md:hidden">
            {/* Mobile Button */}
            <button onClick={() => setMenuOpen(!menuOpen)}>
              {menuOpen ? (
                <img src={x} alt="Menu" className="w-8 h-8" />
              ) : (
                <img src={menu} alt="Menu" className="w-8 h-8" />
              )}
            </button>
          </div>

        </div>

        {/* Mobile Menu */}
        {menuOpen && (
          <div className="md:hidden absolute top-20 right-0 w-48 bg-[#417571] flex flex-col p-6" id="mobile-menu">
            <ul>
              <NavItem to="/consultas" label="Consultas" />
              <NavItem to="/faq" label="FAQ" />
              <NavItem to="/chat" label="Chat" />
              <NavItem to="/contato" label="Contato" />
            </ul>
          </div>
        )}
      </header>

    </>
  );
};
export default Header;
