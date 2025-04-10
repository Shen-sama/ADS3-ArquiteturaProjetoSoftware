import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { PessoaService } from './pessoa.service';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule, HttpClientModule],
  providers: [PessoaService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'pessoa-view';

  teste: string = "-incluindo-";

  nomeUsuario: string = "Jose";

  nome?: string;

  cpf?: string;

  telefone?: string;

  constructor(private pessoaService: PessoaService){

  }
  
  salvar(): void{
    console.log(this.nome);
    console.log(this.cpf);
    console.log(this.telefone);

    let msg = {"nome": this.nome, "cpf": this.cpf, "telefone": this.telefone};
    console.log(msg);

    this.pessoaService.adicionarPessoa(msg).subscribe(
      {
        next: (res) => console.log('Pessoa adicionada:', res),
        error: (err) => console.error('Erro:', err)
      }
    );


  }

}
