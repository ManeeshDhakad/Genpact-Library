import { LibModel} from '../models/lib-model';
import { BookModel} from '../models/book-model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpHeaders } from '@angular/common/http';
import { Observable,  of } from 'rxjs';
import { environment } from 'src/environments/environment'

@Injectable({
  providedIn: 'root'
})
export class LibService {

  constructor(private httpClient : HttpClient) { }


  async getAllLibs() : Promise<LibModel[]> {
    try {
      var requestUrl = `${environment.libServiceUrl}/allLibs`;
      return await this.httpClient.get<LibModel[]>(requestUrl).toPromise();
    } catch (error) {
      console.log(error);  
    }
  }

  async getAllBooks(libId : number) : Promise<BookModel[]> {
    try {
      var requestUrl = `${environment.libServiceUrl}/lib/` +  libId + `/allBooks`;
      return await this.httpClient.get<BookModel[]>(requestUrl).toPromise();
    } catch (error) {
      console.log(error);  
    }
  }
}
