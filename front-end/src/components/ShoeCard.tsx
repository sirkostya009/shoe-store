import React from "react";
import {ShortShoeModel} from "../model/shoes";
import "../styles/Shoe.css";
import {useNavigate} from "react-router-dom";

type ShoeCardProps = {
  shoe: ShortShoeModel
}

function ShoeCard({ shoe }: ShoeCardProps) {
  const navigate = useNavigate();

  const handleClick = () => navigate(`/shoe/${shoe.id}`);

  return (
    <div className="shoe-container" onClick={handleClick}>
      <div className="shoe-image-wrapper">
        {shoe.previewImage
          ? <img className="shoe-image" src={`http://localhost:8000/pictures/${shoe.previewImage}`} alt={shoe.name} />
          : <div className="shoe-image-placeholder"></div>
        }
      </div>
      <div className="shoe-details">
        <div className="shoe-name">{shoe.name}</div>
        <div className="shoe-price">${shoe.price.toFixed(2)}</div>
        {shoe.rating != null && (
          <div className="shoe-rating">{shoe.rating.toFixed(1)}</div>
        )}
        <button className="buy-button">Buy Now</button>
      </div>
    </div>
  );
}

export default ShoeCard;
