import {BookModel} from 'src/app/models/book-model';


export class LibModel {
    id?: number;
    name? : string;
    books? : BookModel[];
    description? : string;
}
