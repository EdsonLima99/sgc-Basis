import { throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { TurmaFormacaoModel } from './../models/turma_formacao.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TurmaFormacaoService {

  constructor(private http: HttpClient) { }

  protected UrlService: string = environment.apiUrl;

  public buscarTodas(): Observable<TurmaFormacaoModel[]>{
    return this.http.get<TurmaFormacaoModel[]>(this.UrlService + '/turmas_formacao');
  }

  public buscar(id: number): Observable<TurmaFormacaoModel> {
    return this.http.get<TurmaFormacaoModel>(`${this.UrlService}/turmas_formacao/${id}`).pipe(
      map(this.jsonDataToResource.bind(this)),
      catchError(this.handleError)
    )
  }

  public inserir(resource: TurmaFormacaoModel): Observable<TurmaFormacaoModel> {
    return this.http.post<TurmaFormacaoModel>(this.UrlService + '/turmas_formacao', resource).pipe(
      map(this.jsonDataToResource.bind(this)),
      catchError(this.handleError)
    )
  }

  public excluir(id: number): Observable<TurmaFormacaoModel> {
    const url = `${this.UrlService}/turmas_formacao/${id}`;

    return this.http.delete<TurmaFormacaoModel>(url).pipe(
      map(() => null),
      catchError(this.handleError)
    )
  }

  protected jsonDataToResources(jsonData: any[]): TurmaFormacaoModel[] {
    const colaboradores: TurmaFormacaoModel[] = [];
    jsonData.forEach(element => colaboradores.push(element as TurmaFormacaoModel));
    return colaboradores
  }

  protected jsonDataToResource(jsonData: any): TurmaFormacaoModel {
    return jsonData as TurmaFormacaoModel;
  }

  protected handleError(error: any): Observable<any>{
    console.log("ERRO NA REQUISIÇÃO => ", error);
    return throwError(error);
  }

}
