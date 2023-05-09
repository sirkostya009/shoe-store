import React, { useState } from "react";

interface ReviewFormProps {
  onSubmit: (rating: number | null, text: string) => void;
  onClose: () => void;
}

function ReviewForm({ onSubmit, onClose }: ReviewFormProps) {
  const [rating, setRating] = useState<number | null>(null);
  const [text, setText] = useState<string>("");

  const handleRatingChange = (event: React.ChangeEvent<HTMLInputElement>) => setRating(Number(event.target.value));

  const handleTextChange = (event: React.ChangeEvent<HTMLTextAreaElement>) => setText(event.target.value);

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const trimmed = text.trim();

    if (trimmed.length !== 0) {
      onSubmit(rating, trimmed);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="mb-3">
        <label htmlFor="rating" className="form-label">
          Stars:
        </label>
        <div>
          <input
            type="radio"
            id="1"
            name="rating"
            value="1"
            onChange={handleRatingChange}
          />
          <label htmlFor="1" className="ms-2 me-4">
            1
          </label>
          <input
            type="radio"
            id="2"
            name="rating"
            value="2"
            onChange={handleRatingChange}
          />
          <label htmlFor="2" className="ms-2 me-4">
            2
          </label>
          <input
            type="radio"
            id="3"
            name="rating"
            value="3"
            onChange={handleRatingChange}
          />
          <label htmlFor="3" className="ms-2 me-4">
            3
          </label>
          <input
            type="radio"
            id="4"
            name="rating"
            value="4"
            onChange={handleRatingChange}
          />
          <label htmlFor="4" className="ms-2 me-4">
            4
          </label>
          <input
            type="radio"
            id="5"
            name="rating"
            value="5"
            onChange={handleRatingChange}
          />
          <label htmlFor="5" className="ms-2">
            5
          </label>
        </div>
      </div>
      <div className="mb-3">
        <label htmlFor="text" className="form-label">
        </label>
        <textarea
          id="text"
          className="form-control"
          value={text}
          onChange={handleTextChange}
        />
      </div>
      <div className="d-flex justify-content-end">
        <button type="submit" className="btn btn-primary me-2">
          Submit
        </button>
        <button type="button" className="btn btn-secondary" onClick={onClose}>
          Cancel
        </button>
      </div>
    </form>
  );
}

export default ReviewForm;
