import { catchError } from 'rxjs/operators';
import { ColaboradorModel } from './../models/colaborador.model';
import { Observable, throwError } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {

   constructor(private http: HttpClient) { }

   protected UrlService: string = environment.apiUrl;

   public buscarTodas(): Observable<ColaboradorModel[]>{
       return this.http.get<ColaboradorModel[]>(this.UrlService + '/colaboradores')
   }

  public buscar(id: number): Observable<ColaboradorModel> {
    return this.http.get(`${this.UrlService}/${id}`).pipe(
      map(this.jsonDataToResource.bind(this)),
      catchError(this.handleError)
    )
  }

  public inserir(resource: ColaboradorModel): Observable<ColaboradorModel> {
    return this.http.post(this.UrlService + '/colaboradores', resource).pipe(
      map(this.jsonDataToResource.bind(this)),
      catchError(this.handleError)
    )
  }

  public atualizar(resource: ColaboradorModel): Observable<ColaboradorModel> {
    const url = `${this.UrlService}/${resource.id}`;

    return this.http.put(url, resource).pipe(
      map(() => resource),
      catchError(this.handleError)
    )
  }

  public excluir(id: number): Observable<any> {
    const url = `${this.UrlService}/${id}`;

    return this.http.delete(url).pipe(
      map(() => null),
      catchError(this.handleError)
    )
  }

  protected jsonDataToResources(jsonData: any[]): ColaboradorModel[] {
    const colaboradores: ColaboradorModel[] = [];
    jsonData.forEach(element => colaboradores.push(element as ColaboradorModel));
    return colaboradores
  }

  protected jsonDataToResource(jsonData: any): ColaboradorModel {
    return jsonData as ColaboradorModel;
  }

  protected handleError(error: any): Observable<any>{
    console.log("ERRO NA REQUISIÇÃO => ", error);
    return throwError(error);
  }
}
