import TopHome from "./HeaderHome/TopHome";
import MainHome from "./MainHome/MainHome";
import Footer from "../Footer/Footer";

import './Home.css';

/**
 * O componente representa a página inicial (HOMEPAGE);
 * 
 * @returns Página web inicial
 */
function Home() {
  return (
    <div className="Home">
      <TopHome />
      <MainHome />
      <Footer />
    </div>
  );
}

export default Home;
