import { InventarioService } from './inventario.service';
import { Validators, AbstractControl, ValidatorFn } from '@angular/forms';

export class InventarioValidator {

    static valorUnico(inventarioService: InventarioService): ValidatorFn {
        return (control: AbstractControl): { [key: string]: any } => {
            if (this.isPresent(Validators.required(control))) { return null; }

            return new Promise((resolve, reject) => {
                inventarioService.getInventarioById(control.value).subscribe(data => {
                    console.log(data);
                    if (data.id != null) {
                        resolve({ valorUnico: true });
                    }
                    else {
                        resolve(null);
                    }
                }, error => {
                    console.log(error);
                });
            });

        }
    }

    static isPresent(obj: any): boolean {
        return obj !== undefined && obj !== null;
    }
}


