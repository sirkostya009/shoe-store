import React, {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {DetailedShoeModel} from "../model/shoes";
import Reviews from "../components/Reviews";

function Shoe() {
  const { id } = useParams();
  const [shoe, setShoe] = useState<DetailedShoeModel | null>(null);

  useEffect(() => {
    fetch(`http://localhost:8000/shoes/${id}`)
      .then((response) => response.json())
      .then(setShoe);
  }, [id]);

  if (!shoe) {
    return <div>Loading...</div>;
  }

  return (
    <div className="container mt-4">
      <div className="row">
        <div className="col-md-4">
          {shoe.previewImage ? (
            <img
              className="img-fluid rounded mb-3"
              src={`http://localhost:8000/pictures/${shoe.previewImage}`}
              alt={shoe.name}
            />
          ) : (
            <div
              className="d-flex justify-content-center align-items-center mb-3"
              style={{ height: "300px", backgroundColor: "#eee" }}
            >
              No Preview Image
            </div>
          )}
        </div>
        <div className="col-md-8">
          <h2>{shoe.name}</h2>
          {shoe.rating && (
            <div className="mb-3">
              Rating: {shoe.rating.toFixed(1)} / 5.0
            </div>
          )}
          <div className="mb-3">{shoe.description}</div>
          <div className="mb-3">Color: {shoe.color}</div>
          <div className="mb-3">Country: {shoe.country}</div>
          <div className="mb-3">
            Sizes: {shoe.sizes.join(", ")}
          </div>
          <div className="mb-3">
            Price: ${shoe.price.toFixed(2)}
          </div>
          <button className="btn btn-primary">Buy Now</button>
        </div>
      </div>
      <Reviews id={shoe.id}/>
    </div>
  );
}

export default Shoe;
