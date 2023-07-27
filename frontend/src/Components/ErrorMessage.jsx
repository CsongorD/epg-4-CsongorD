import "../css/ErrorMessage.css"

function ErrorMessage({ text }) {
    return (
        <div className="content-holder">
            <div className="errormessage-container">
                <h2 className="errormessage-text">  Sorry, an error has occured: </h2>
                <h2 className="errormessage-text">   {text}</h2>
            </div>
        </div>
    );
}

export default ErrorMessage;
