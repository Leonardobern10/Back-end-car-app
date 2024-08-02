import "./mainHome.css";
import { IoCarSportOutline } from "react-icons/io5";
import { IoSparklesOutline } from "react-icons/io5";
import { AiOutlineLike } from "react-icons/ai";
import { GrConfigure } from "react-icons/gr";
import { NavLink } from "react-router-dom";

/**
 * 
 * O componente forma o MAIN da nossa aplicação
 * quando na HOMEPAGE.
 * 
 * @returns Parte principal da HomePage.
 */
function MainHome() {
  return (
    <div>
      <div className="invite">
        <h2>Novos modelos para todos os gostos</h2>
        <div className="mainModels">
          <button>HONDA ACCORD 2024</button>
        </div>
        <div className="mainModels">
          <button>AUDI A3 2024</button>
        </div>
      </div>
      <main>
        <div>
          <div className="qualificators">
            <p>PROCURE E COMPRE</p>
            <h4>Encontre o seu carro</h4>
            <div className="containerQualify">
              <IoSparklesOutline className="iconStar" />
              <IoCarSportOutline className="iconCar" />
              <p>Carros 0 KM</p>
            </div>
            <div className="containerQualify">
              <AiOutlineLike className="iconStar" />
              <IoCarSportOutline className="iconCar" />
              <p>Os mais desejados</p>
            </div>
            <div className="containerQualify">
              <GrConfigure className="iconStar" />
              <IoCarSportOutline className="iconCar" />
              <p>Configure o seu</p>
            </div>
            <div className="containerButtonCars">
              <button>
                <NavLink to="/vehicles" activeClassName="active">Carros</NavLink>
              </button>
            </div>
          </div>
        </div>
      </main>
    </div>
  );
}

export default MainHome;
