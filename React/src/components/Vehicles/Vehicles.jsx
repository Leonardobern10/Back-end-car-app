import HeaderVehicles from "../Vehicles/HeaderVehicles/HeaderVehicles";
import MainVehicles from "./MainVehicles/MainVehicles";
import Footer from "../Footer/Footer";
import "./Vehicles.css";

/**
 * O componente representa uma página web destinada 
 * à exibição de produtos da loja.
 * 
 * @returns Página web
 */
function Vehicles() {
  return (
    <div className="vehicles">
      <HeaderVehicles />
      <MainVehicles />
      <Footer />
    </div>
  )
}

export default Vehicles;
