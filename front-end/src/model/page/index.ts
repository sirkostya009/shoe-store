interface Pageable {
  sort: Sort
  offset: number
  pageSize: number
  pageNumber: number
  unpaged: boolean
  paged: boolean
}

interface Sort {
  empty: boolean
  sorted: boolean
  unsorted: boolean
}

export interface Page<T> {
  content: T[]
  first: boolean
  last: boolean
  empty: boolean
  totalPages: number
  totalElements: number
  size: number
  number: number
  numberOfElements: number
  pageable: Pageable
  sort: Sort
}
