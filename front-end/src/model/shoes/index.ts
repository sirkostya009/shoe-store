export interface DetailedShoeModel {
  id: string
  name: string
  description: string
  rating: number | null
  color: string
  country: string
  sizes: number[]
  previewImage: string | null
  price: number
}

export interface ShortShoeModel {
  id: string
  name: string
  rating: number | null
  previewImage: string | null
  price: number
}
