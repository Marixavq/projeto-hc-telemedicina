function Titulo({ texto }: { texto: string }) {
    return (
        <>
            <h1 className="font-bold text-center text-2xl md:text-3xl w-4/5  lg: mx-auto py-4">{texto}</h1>
        </>
    );
}

export default Titulo