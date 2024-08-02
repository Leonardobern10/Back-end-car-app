
import "./Footer.css";
import { GrInstagram } from "react-icons/gr";
import { BsGithub } from "react-icons/bs";
import { CiLinkedin } from "react-icons/ci";
import { LuCopyright } from "react-icons/lu";

/**
 * O componente representa o rodapé da aplicação 
 * utilizado em todos os pontos da mesma.
 * 
 * @returns Componente que forma o rodapé padrão da aplicação.
 */
function Footer() {
  return (
    <div>
      <footer className="Footer">
        <div className="containerAdress">
          <p>R. Nova York, Miami - USA</p>
          <p>+55 12 345678910</p>
          <p>email@email.com</p>
        </div>
        <div className="containerSocialNetworks">
          <div>
            <GrInstagram className="iconNetworks" />
          </div>
          <div>
            <BsGithub className="iconNetworks" />
          </div>
          <div>
            <CiLinkedin className="iconNetworks" />
          </div>
        </div>
        <div>
          <p>
            <span>
              <LuCopyright className="copyRight"/>
            </span>
            LeonardoBernardo
          </p>
        </div>
      </footer>
    </div>
  );
}

export default Footer;
