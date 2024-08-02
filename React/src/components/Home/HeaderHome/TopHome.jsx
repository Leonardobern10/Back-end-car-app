import "./HeaderHome.css";
import { FaFirstdraft } from "react-icons/fa6";
import { IoHomeOutline } from "react-icons/io5";
import { IoCarOutline } from "react-icons/io5";
import { CiShoppingCart } from "react-icons/ci";
import { Link } from "react-router-dom";

/**
 * O compoenente representa a parte inicial da aplicação
 * que visa chamar a atenção dos usuários abrigando um vídeo
 * e sobrepondo um cabeçalho.
 */
function TopHome() {
  return (
        <div className="headerHome">
      <div className="containerVideo">
        <video
          autoPlay
          muted
          loop
          id="background-video"
          src="https://cdn.pixabay.com/video/2023/10/12/184734-873923034_large.mp4"
        />
      </div>
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

export default TopHome;
