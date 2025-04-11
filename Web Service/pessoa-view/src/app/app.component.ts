import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { PessoaService } from './pessoa.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Pessoa } from './pessoa';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FormsModule, HttpClientModule, CommonModule],
  providers: [PessoaService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'pessoa-view';

  teste: string = "-incluindo-";

  nomeUsuario: string = "Jose";

  id?: number;
  
  nome?: string;

  cpf?: string;

  telefone?: string;

  pessoas:Array<Pessoa> = [];

  constructor(private pessoaService: PessoaService){

  }

  cpfMask(event: any) {
    let value = event.target.value.replace(/\D/g, '');
    if (value.length > 11) value = value.substring(0, 11);
    value = value.replace(/(\d{3})(\d)/, '$1.$2');
    value = value.replace(/(\d{3})(\d)/, '$1.$2');
    value = value.replace(/(\d{3})(\d{1,2})$/, '$1-$2');
    event.target.value = value;
    this.cpf = value;
  }
  
  telefoneMask(event: any) {
    let value = event.target.value.replace(/\D/g, '');
    if (value.length > 11) value = value.substring(0, 11);
    value = value.replace(/^(\d{2})(\d)/g, '($1) $2');
    value = value.replace(/(\d{5})(\d{4})$/, '$1-$2');
    event.target.value = value;
    this.telefone = value;
  }

  deletar(id?: number) {
    if (!id) return;
    
    if (confirm('Deseja realmente deletar esta pessoa?')) {
      this.pessoaService.deletar(id).subscribe(() => {
        this.listar();
      });
    }
  }

  listar(): void{
    this.pessoaService.listar().subscribe({
      next: (resp) => {
        this.pessoas = resp as Pessoa[];
        console.log(this.pessoas);
      },
      error: (resp) => {
        
      }
    });
  }
  
  salvar(): void{
    console.log(this.nome);
    console.log(this.cpf);
    console.log(this.telefone);

    let msg = {"id": this.id, "nome": this.nome, "cpf": this.cpf, "telefone": this.telefone};
    console.log(msg);

    this.pessoaService.adicionarPessoa(msg).subscribe(
      {
        next: (res) => console.log('Pessoa adicionada:', res),
        error: (err) => console.error('Erro:', err)
      }
    );


  }

}
