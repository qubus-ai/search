import { Jeopardy } from './jeopardy';
export class JeopardyPaged {
    content: Jeopardy[];
    pageable: {
        sort: {
            sorted: boolean;
            unsorted: boolean;
            empty: boolean;
        },
        offset: number;
        "pageSize": number,
        "pageNumber": number,
        "paged": boolean,
        "unpaged": boolean
    }
    last: boolean
    totalElements: number;
    totalPages: number;
    size: number;
    number: number;
    sort: {
        sorted: boolean;
        unsorted: boolean;
        empty: boolean;
    }
    numberOfElements: number;
    first: boolean;
    empty: boolean;
}