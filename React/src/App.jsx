import Home from "./components/Home/Home";
import { Routes, Route } from "react-router-dom";
import Vehicles from "./components/Vehicles/Vehicles";
import './App.css';

function App() {
  return (
    /**
     * Armazena as rotas da página
     */
    <Routes>
      <Route exact path="/" element={<Home />} />
      <Route path="/vehicles" element={<Vehicles />} />
    </Routes>
  );
}

export default App;
