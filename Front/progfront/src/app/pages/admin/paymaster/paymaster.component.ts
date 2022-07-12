import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LeaveserviceService } from 'src/app/services/leaveservice.service';
import { LoginService } from 'src/app/services/login.service';
import { PayrollService } from 'src/app/services/payroll.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-paymaster',
  templateUrl: './paymaster.component.html',
  styleUrls: ['./paymaster.component.css']
})
export class PaymasterComponent implements OnInit {

  payrolls:any=[];
  payrollObj={};
  constructor(private userService:UserService,
    private snack:MatSnackBar,
    private leaveService:LeaveserviceService,
    public login:LoginService,
    public payroll:PayrollService) { }

  ngOnInit(): void {
    this.payroll.viewPayRolls().subscribe(data=>this.payrolls=data);
  }

  updatePayrolls(payrollObj:any){
    console.log(payrollObj);
    return this.payroll.updatePayrolls(payrollObj).subscribe(
      data=>{
        this.snack.open("Payrolls are Updated!!",'',{
          duration:2000,
          
        })
      }
    );
  }
}
