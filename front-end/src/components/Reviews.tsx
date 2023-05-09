import React, {useEffect, useState} from "react";
import {Review, ReviewPost} from "../model/review/index.js";
import {Page} from "../model/page";
import ReviewCard from "./ReviewCard";
import {useUser} from "../hooks";
import ReviewForm from "./ReviewForm";

type ReviewsProps = {
  id: string
}

function Reviews({ id }: ReviewsProps) {
  const [reviews, setReviews] = useState<Page<Review>>();
  const [showForm, setShowForm] = useState(false);
  const { user } = useUser();

  useEffect(() => {
    fetch(`http://localhost:8000/shoes/${id}/reviews`)
      .then((response) => response.json())
      .then(setReviews);
  }, [id]);

  const handleShowReviewForm = () => setShowForm(true);

  const handleCloseReviewForm = () => setShowForm(false);

  const handleSubmit = (rating: number | null, text: string) => {
    const review: ReviewPost = { rating, text };

    console.log(review);
    fetch(`http://localhost:8000/shoes/${id}/reviews`, {
      method: "POST",
      body: JSON.stringify(review),
      headers: {
        'Authorization': `Bearer ${user!.jwt}`,
        'Content-Type': 'application/json'
      }
    })
      .then((response) => {
        if (!response.ok) {
          // show that something went wrong
        }
      });

    setTimeout(() => {
      fetch(`http://localhost:8000/shoes/${id}/reviews`)
        .then((response) => response.json())
        .then(setReviews)
    }, 500);

    handleCloseReviewForm();
  };

  return (
    <div className="mt-4">
      <h3>Reviews</h3>
      {user && (
        <button
          className="btn btn-primary float-end mb-3"
          type="button"
          onClick={handleShowReviewForm}
        >
          Leave a Review
        </button>
      )}
      {showForm && (
        <ReviewForm onSubmit={handleSubmit} onClose={handleCloseReviewForm} />
      )}
      {reviews?.content.length === 0 ? (
        <div>No reviews yet.</div>
      ) : (
        reviews?.content.map((review) => (
          <ReviewCard key={review.id} review={review} />
        ))
      )}
    </div>
  );
}

export default Reviews;
