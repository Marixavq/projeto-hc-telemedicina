import { useEffect } from "react";

import Titulo from "../../components/Titulo/Titulo";

interface ChatProps {
    containerId?: string;
}

export function Chat({ containerId = "chat-container" }: ChatProps) {
    useEffect(() => {
        if (!(window as any).watsonAssistantChatOptions) {
            (window as any).watsonAssistantChatOptions = {
                integrationID: "1ca58ac9-d176-472f-90a1-3c5dff195bc2",
                region: "us-south",
                serviceInstanceID: "3894291c-8c0f-45a2-940a-41fefc55fb58",
                element: document.getElementById(containerId),
                hideCloseButton: true,
                showRestartButton: true,
                openChatByDefault: true,
                onLoad: function (instance: any) {
                    instance.render();
                },
            };

            if (!document.getElementById("watson-script")) {
                const script = document.createElement("script");
                script.id = "watson-script";
                script.src =
                    "https://web-chat.global.assistant.watson.appdomain.cloud/versions/latest/WatsonAssistantChatEntry.js";
                script.async = true;
                document.head.appendChild(script);
            }
        }
    }, [containerId]);


    return (
        <>
            <div className="bg-[#d9d9d9]">
                <Titulo texto="Chat"></Titulo>
                <div id={containerId} className="h-96 w-full"></div>

            </div>
        </>
    );
}
export default Chat