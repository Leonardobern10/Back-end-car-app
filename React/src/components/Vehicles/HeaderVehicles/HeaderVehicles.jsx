import "./HeaderVehicles.css";
import { FaFirstdraft } from "react-icons/fa6";
import { IoHomeOutline } from "react-icons/io5";
import { IoCarOutline } from "react-icons/io5";
import { CiShoppingCart } from "react-icons/ci";
import { Link } from "react-router-dom";

/**
 * 
 * O componente forma o cabeçalho da aplicação 
 * quando na página de veiculos.
 * 
 * @returns Cabeçalho da aplicação.
 */
function HeaderVehicles() {
  return (
    <div className="headerVehicles">
      <header>
        <nav>
          <div className="logo">
            <FaFirstdraft />
          </div>
          <ul>
            <li>
              <Link to="/">
                <IoHomeOutline />
              </Link>
            </li>
            <li>
              <Link to="/vehicles">
                <IoCarOutline />
              </Link>
            </li>
            <li>
              <Link to="/shop-cart">
                <CiShoppingCart />
              </Link>
            </li>
          </ul>
        </nav>
      </header>
    </div>
  );
}

export default HeaderVehicles;
