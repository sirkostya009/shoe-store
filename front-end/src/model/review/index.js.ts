export interface Review {
  id: string
  rating: number
  author: string
  text: string
}

export interface ReviewPost {
  rating: number | null
  text: string
}
