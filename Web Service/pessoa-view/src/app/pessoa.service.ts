import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
export class PessoaService {
  private http = inject(HttpClient);
  private readonly apiUrl = 'http://localhost:8080/pessoa';

  adicionarPessoa(pessoa: any): Observable<any> {
    return this.http.post(this.apiUrl, pessoa);
  }
}
