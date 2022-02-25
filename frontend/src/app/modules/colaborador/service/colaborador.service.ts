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
    return this.http.get<ColaboradorModel>(`${this.UrlService}/colaboradores/${id}`).pipe(
      map(this.jsonDataToResource.bind(this)),
      catchError(this.handleError)
    )
  }

  public inserir(resource: ColaboradorModel): Observable<ColaboradorModel> {
    return this.http.post<ColaboradorModel>(this.UrlService + '/colaboradores', resource).pipe(
      map(this.jsonDataToResource.bind(this)),
      catchError(this.handleError)
    )
  }

  public atualizar(resource: ColaboradorModel): Observable<ColaboradorModel> {
    const url = `${this.UrlService}/colaboradores/${resource.id}`;

    return this.http.put<ColaboradorModel>(url, resource).pipe(
      map(() => resource),
      catchError(this.handleError)
    )
  }

  public excluir(id: number): Observable<ColaboradorModel> {
    const url = `${this.UrlService}/colaboradores/${id}`;

    return this.http.delete<ColaboradorModel>(url).pipe(
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
