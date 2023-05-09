import React, {useEffect, useState} from "react";
import ShoeCard from "./ShoeCard";
import {Page} from "../model/page";
import {ShortShoeModel} from "../model/shoes";
import "../styles/shoe-container.css";

function Shoes() {
  const [shoes, setShoes] = useState<Page<ShortShoeModel>>();

  useEffect(() => {
    fetch('http://localhost:8000/shoes')
      .then((response) => response.json())
      .then(setShoes);
  }, []);

  return (
    <div className="shoe-container-wrapper">
      <div className="shoe-container-row">
        {shoes?.content.map((shoe) => (
          <div key={shoe.id} className="shoe-card">
            <ShoeCard shoe={shoe} />
          </div>
        ))}
      </div>
    </div>
  );
}

export default Shoes;
