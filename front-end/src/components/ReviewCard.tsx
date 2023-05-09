import {Review} from "../model/review/index.js";

type ReviewProps = {
  review: Review;
};

function ReviewCard({ review }: ReviewProps) {
  const { rating, author, text } = review;

  return (
    <div className="card mb-3">
      <div className="card-body">
        <div className="d-flex justify-content-between">
          <div>Rating: {rating}</div>
          <div>Author: {author}</div>
        </div>
        <div>{text}</div>
      </div>
    </div>
  );
}

export default ReviewCard;
