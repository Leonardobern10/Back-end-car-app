import "./MainVehicles.css";
import { useState, useEffect } from "react";
import axios from "axios";

/**
 * O componente forma o MAIN da aplicação quando 
 * na página destianda a exibição dos veiculos.
 * 
 * @returns Seção MAIN da aplicação.
 */
function MainVehicles() {
  /* Armazena o estado dos veiculos e fornece o método para manipulá-lo */
  const [vehicles, setVehicles] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  /* Utilização do HOOK - useEffect para realizar a requisição de dados
  que estão disponíveis na nossa API */
  useEffect(() => {
    const fetchVehicles = async () => {
      try {
        const response = await axios.get("http://localhost:8080/cars");
        /* Monitorar o status da respota */
        console.log("API Response:", response.data);
        setVehicles(response.data);
        setLoading(false);
      } catch (error) {
        setError(error);
        setLoading(false);
      }
    };
    fetchVehicles();
  }, []);

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error.message}</p>;

  return (
    <div className="mainVehicles">
      <div className="atention">
        <h2>Não fique de fora</h2>
        <h3>Realize seu sonho</h3>
        <h4>Conquiste a máquina que sempre desejou!</h4>
      </div>
      <div className="containerVehicles">
        <ul>    
          {vehicles.map(car => (
            <li className="carItem" key={car.carId}>
              <img
                src={car.url}
                alt={car.model}
                style={{ width: "100%", height: "100%"}}
              />
              <h3 className="modelCar">{car.model}</h3>
              <p className="carValue">{"R$ " + car.carValue.toLocaleString('pt-BR') + ",00"}</p>
              <hr />
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default MainVehicles;
