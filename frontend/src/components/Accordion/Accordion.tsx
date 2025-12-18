import { useState } from "react";

import ChevronDown from "../../assets/imagens/chevron-down.svg";

function Accordion({ title, content }: { title: string; content: React.ReactNode; }) {
    const [isOpen, setIsOpen] = useState(false);

    return (
        <>
            <div className="border border-black rounded p-5 w-80 md:w-96">
                <button onClick={() => setIsOpen(!isOpen)} className=" flex items-center justify-between w-full text-base md:text-lg py-2">
                    {title}
                    <img
                        src={ChevronDown}
                        alt="chevron"
                        className={`w-5 h-5 transition-transform duration-300 ${isOpen ? "rotate-180" : "rotate-0"
                            }`}
                    />
                </button>

                {isOpen && (
                    <div className="text-base md:lg">
                        <div>{content}</div>
                    </div>
                )}
            </div>
        </>
    );
}

export default Accordion