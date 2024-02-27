import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder,FormControl, Validators} from '@angular/forms';
import {CreationServiceService} from 'src/app/creation-service.service';
import {selectItem} from 'src/app/selectItem';
import { seller } from '../seller';
import { sellerCompanyDTO } from '../sellerCompanyDTO';
import { sellerCompany } from '../sellerCompany';
import { subTeam } from '../subTeam';
import { subTeamDTO } from '../subTeamDTO';
import { SellerDTO } from '../SellerDTO';
import { User } from '../User';
import { vehicleDTO } from '../vehicleDTO';
import { IDropdownSettings } from 'ng-multiselect-dropdown';
import { multiSelectItem } from '../multiSelectItem';

@Component({
  selector: 'app-actionspage',
  templateUrl: './actionspage.component.html',
  styleUrls: ['./actionspage.component.css']
})
export class ActionspageComponent implements OnInit {


  isCompanyCreationPage : boolean = false;
  isViewCompanyPage: boolean = false;
  isSubTeamCreationPage : boolean = false;
  isSellerCreationPage : boolean = false;
  isUserCreationPage : boolean = false;
  isUpdateSellerStatusPage: boolean = false;
  isLoginPage : boolean = false;
  loginsuccessful: boolean = false;
  createVehicle: boolean = false;
  showAuctionFields: boolean = true;
  showError : boolean = false;
  updateSellerStatusError : boolean = false;
  updateSellerStatusSuccess : boolean = false;
  showLoginError: boolean = false;
  showFailureMessage: boolean = false;
  showSuccessMessage: boolean = false;
  showSuccessForCompanyAdd : boolean = false;
  showErrorForCompanyAdd: boolean = false;

  showSuccessForSubTeamAdd : boolean = false;
  showErrorForSubTeamAdd: boolean = false;

  showSuccessForSellerAdd : boolean = false;
  showErrorForSellerAdd: boolean = false;

  showSuccessForUserAdd : boolean = false;
  showErrorForUserAdd: boolean = false;

  companiesDropDown: selectItem[] = [];
  subTeamsDropDown: selectItem[] = [];
  sellerDropDown: selectItem[] = [];
  subTeamsMultiDropDown: multiSelectItem[] = [];
  selectedMultiSubTeams: selectItem[] = [];
  selectedSubTeams: Array<number> = [];
  currentUser: User = new User();
  currentUserVehicles: vehicleDTO[] = [];
  currentUserAuctionVehicles: vehicleDTO[] = [];
  currentUserDirectVehicles: vehicleDTO[] = [];
  dropdownSettings : IDropdownSettings= {};

  companiesList: sellerCompany[] = [];
  companyDTOList: sellerCompanyDTO[] = [];
  subTeamsList: subTeam[] = [];
  sellerNousersList: seller[] = [];
  sellersList: seller[] = [];

  addCompanyForm: FormGroup;
  addSubTeamForm: FormGroup;
  addSellerForm: FormGroup;
  addUserForm: FormGroup;
  loginForm: FormGroup ;
  vehicleForm: FormGroup;
  changeSellerStatusForm: FormGroup;

  constructor(private fb: FormBuilder, private creationService: CreationServiceService) { }

  ngOnInit(): void {
    this.isCompanyCreationPage = true;

    this.showErrorForCompanyAdd = false;
    this.showSuccessForCompanyAdd = false;
    this.addCompanyForm= this.createCompanyFormGroup();

    this.dropdownSettings = {
      singleSelection: false,
      idField: 'value',
      textField: 'label',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
  }

  createCompanyFormGroup(){
    return new FormGroup({
      companyName: new FormControl("",[Validators.required]),
      country: new FormControl("",[Validators.required]),
      line1: new FormControl("",[Validators.required]),
      line2: new FormControl(""),
      city: new FormControl("",[Validators.required]),
      state: new FormControl("",[Validators.required]),
      zipCode: new FormControl("",[Validators.required])
    });
  }

  createSubTeamFormGroup(){
    return new FormGroup({
      subTeamName: new FormControl("",[Validators.required]),
      companyId: new FormControl("",[Validators.required]),
      country: new FormControl("",[Validators.required]),
      line1: new FormControl("",[Validators.required]),
      line2: new FormControl(""),
      city: new FormControl("",[Validators.required]),
      
      state: new FormControl("",[Validators.required]),
      zipCode: new FormControl("",[Validators.required])
    });
  }

  createSellerFormGroup(){
    return new FormGroup({
      sellerName: new FormControl("",[Validators.required]),
      companyId: new FormControl("",[Validators.required]),
      subTeams: new FormControl([Validators.required]),
      email: new FormControl("",[Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]),
      phone: new FormControl("",[Validators.required, Validators.pattern("^[0-9]*$")]),
      ext: new FormControl("",[Validators.pattern("^[0-9]*$")])
    });
  }

  createUserFormGroup(){
    return new FormGroup({
      sellerId: new FormControl("",[Validators.required]),
      userName: new FormControl("",[Validators.required]),
      password: new FormControl("",[Validators.required])
    });
  }

  createVehicleFormGroup(){
    return new FormGroup({
      vin: new FormControl("",[Validators.required]),
      modelName: new FormControl("",[Validators.required]),
      vehicleCompany: new FormControl("",[Validators.required]),
      isAuction: new FormControl("Yes",[Validators.required]),
      auctionDate: new FormControl(""),
      basePrice: new FormControl("",[ Validators.pattern("^[0-9]*$")]),
      price: new FormControl("", [ Validators.pattern("^[0-9]*$")])
    });
  }

  AddSellerCompany(){
    let body = new sellerCompanyDTO();
    this.showErrorForCompanyAdd = false;
    this.showSuccessForCompanyAdd = false;
    if(this.addCompanyForm.valid){
      this.showError = false;

      body.companyName = this.addCompanyForm?.get("companyName")?.value;
      body.country = this.addCompanyForm?.get("country")?.value;
      body.line1 = this.addCompanyForm?.get("line1")?.value;
      body.line2 = this.addCompanyForm?.get("line2")?.value;
      body.city = this.addCompanyForm?.get("city")?.value;
      body.state = this.addCompanyForm?.get("state")?.value;
      body.zipCode = this.addCompanyForm?.get("zipCode")?.value;
  
      this.creationService.addSellerCompany(body).subscribe(
        result => {
          if(result.response == "Added Succesfully"){
            
            this.showSuccessForCompanyAdd = true;
              console.log(result.response);
          }
          else{
            this.showErrorForCompanyAdd = true;
          }
        }
      );
    }
    else{
      this.showError = true;
    }
  }

  AddSubTeam(){
    let body = new subTeamDTO();
    this.showSuccessForSubTeamAdd = false;
    this.showErrorForSubTeamAdd = false;
    if(this.addSubTeamForm.valid){
      this.showError = false;

      body.subTeamName = this.addSubTeamForm?.get("subTeamName")?.value;
      body.companyId = this.addSubTeamForm?.get("companyId")?.value;
      body.country = this.addSubTeamForm?.get("country")?.value;
      body.line1 = this.addSubTeamForm?.get("line1")?.value;
      body.line2 = this.addSubTeamForm?.get("line2")?.value;
      body.city = this.addSubTeamForm?.get("city")?.value;
      body.state = this.addSubTeamForm?.get("state")?.value;
      body.zipCode = this.addSubTeamForm?.get("zipCode")?.value;
  
      this.creationService.addSubTeam(body).subscribe(
        result => {
          if(result.response == "Added Succesfully"){
            
            this.showSuccessForSubTeamAdd = true;
              console.log(result.response);
          }
          else{
            this.showErrorForSubTeamAdd = true;
          }
        }
      );
    }
    else{
      this.showError = true;
    }
  }

  AddSeller(){
    let body = new SellerDTO();

    this.showSuccessForSellerAdd = false;
    this.showErrorForSellerAdd = false;

    if(this.addSellerForm.valid){
      this.showError = false;

      body.sellerName = this.addSellerForm?.get("sellerName")?.value;
      body.email = this.addSellerForm?.get("email")?.value;
      body.phone = this.addSellerForm?.get("phone")?.value;
      body.ext = this.addSellerForm?.get("ext")?.value;
      body.subTeamIds = this.selectedSubTeams;
      body.isSellerActive = true;
  
      this.creationService.addSeller(body).subscribe(
        result => {
          if(result.response == "Added Succesfully"){
            this.showSuccessForSellerAdd = true;
              console.log(result.response);
          }
          else{
            this.showErrorForSellerAdd = true;
          }
        }
      );
    }
    else{
      this.showError = true;
    }
  }


  AddUser(){
    let body = new User();

    this.showSuccessForUserAdd = false;
    this.showErrorForUserAdd = false;
    
    if(this.addUserForm.valid){
      this.showError = false;

      body.sellerId = this.addUserForm?.get("sellerId")?.value;
      body.userName = this.addUserForm?.get("userName")?.value;
      body.password = this.addUserForm?.get("password")?.value;
      body.isUserActive = true;
  
      this.creationService.addUser(body).subscribe(
        result => {
          if(result.response == "Added Succesfully"){
            this.showSuccessForUserAdd = true;
              console.log(result.response);
          }
          else{
            this.showErrorForUserAdd = true;
          }
        }
      );
    }
    else{
      this.showError = true;
    }
    
  }

  createCompanyClick(){

    this.showError = false;

    this.isCompanyCreationPage = true;
    this.isViewCompanyPage = false;
    this.isSubTeamCreationPage = false;
    this.isSellerCreationPage = false;
    this.isUserCreationPage = false;
    this.isLoginPage = false;
    this.isUpdateSellerStatusPage = false;

    this.showErrorForCompanyAdd = false;
    this.showSuccessForCompanyAdd = false;

    this.addCompanyForm = this.createCompanyFormGroup();
  }

  viewCompanyClick(){
    this.showError = false;

    this.isCompanyCreationPage = false;
    this.isViewCompanyPage = true;
    this.isSubTeamCreationPage = false;
    this.isSellerCreationPage = false;
    this.isUserCreationPage = false;
    this.isLoginPage = false;
    this.isUpdateSellerStatusPage = false;

    this.companyDTOList = [];

    this.creationService.getAllCompanyDTOs().subscribe(
      result =>{
        this.companyDTOList = result;
      }
    )

  }

  createSubTeamClick() {
    this.showError = false;

    this.showSuccessForSubTeamAdd = false;
    this.showErrorForSubTeamAdd = false;

    this.isCompanyCreationPage = false;
    this.isViewCompanyPage = false;
    this.isSubTeamCreationPage = true;
    this.isSellerCreationPage = false;
    this.isUserCreationPage = false;
    this.isLoginPage = false;
    this.isUpdateSellerStatusPage = false;

    this.addSubTeamForm = this.createSubTeamFormGroup();

    this.companiesDropDown = [];
    this.creationService.getAllCompanies().subscribe(
      result => {
        this.companiesList = result;

        this.companiesList.forEach(value=> {
          this.companiesDropDown.push({
            label: value.companyName,
            value :value.companyId
          })
        });
      }
    );

  }

  getColorButton(){
    if(this.isCompanyCreationPage == true){
      
        return "header-button-active";
    }
    else{
        return "header-button";
    } 
  }
  createSellerClick() {
    this.showError = false;


    this.showSuccessForSellerAdd = false;
    this.showErrorForSellerAdd = false;
    
    this.isCompanyCreationPage = false;
    this.isViewCompanyPage = false;
    this.isSubTeamCreationPage = false;
    this.isSellerCreationPage = true;
    this.isUserCreationPage = false;
    this.isLoginPage = false;
    this.isUpdateSellerStatusPage = false;

    this.addSellerForm = this.createSellerFormGroup();

    this.companiesDropDown = [];

    this.creationService.getAllCompanies().subscribe(
      result => {
        this.companiesList = result;

        this.companiesList.forEach(value=> {
          this.companiesDropDown.push({
            label: value.companyName,
            value :value.companyId
          })
        });
      }
    );

  }

  onSelectCompany(){
    let selectedCompanyId = this.addSellerForm?.get('companyId')?.value;
    this.subTeamsDropDown = [];

    this.creationService.getSubTeamsForcompanyId(selectedCompanyId).subscribe(
      result=> {
        this.subTeamsList  = result;

        this.subTeamsList.forEach(value => {
          this.subTeamsDropDown.push({
            label: value.subTeamName,
            value :value.subTeamId
          })
        });
      }

    );

  }

  createUserClick(){

    this.showError = false;

    this.showSuccessForUserAdd = false;
    this.showErrorForUserAdd = false;

    this.isCompanyCreationPage = false;
    this.isViewCompanyPage = false;
    this.isSubTeamCreationPage = false;
    this.isSellerCreationPage = false;
    this.isUserCreationPage = true;
    this.isLoginPage = false;
    this.isUpdateSellerStatusPage = false;

    this.addUserForm = this.createUserFormGroup();

    this.sellerDropDown = [];
    this.creationService.getSellersForNoUsers().subscribe(
      result => {
        this.sellerNousersList = result;

        this.sellerNousersList.forEach(value => {
          this.sellerDropDown.push({
            label: value.sellerName,
            value :value.sellerId
          })
        })
      }
    )

  }

  userLoginClick(){
    this.showError = false;
    this.loginsuccessful = false;
    this.isCompanyCreationPage = false;
    this.isViewCompanyPage = false;
    this.isSubTeamCreationPage = false;
    this.isSellerCreationPage = false;
    this.isUserCreationPage = false;
    this.isLoginPage = true;
    this.isUpdateSellerStatusPage = false;

    this.loginForm = this.createLoginFormGroup();
  }

  createLoginFormGroup(){
    return new FormGroup({
      userName: new FormControl("",[Validators.required]),
      password: new FormControl("",[Validators.required])
    });
  }

  createSellerStatusFormGroup(){
    return new FormGroup({
      sellerId: new FormControl("",[Validators.required])
    });
  }
  updateSellerStatusClick(){

    this.showError = false;

    this.updateSellerStatusSuccess = false;
    this.updateSellerStatusError = false;

    this.loginsuccessful = false;
    this.isCompanyCreationPage = false;
    this.isViewCompanyPage = false;
    this.isSubTeamCreationPage = false;
    this.isSellerCreationPage = false;
    this.isUserCreationPage = false;
    this.isLoginPage = false;
    this.isUpdateSellerStatusPage = true;

    this.changeSellerStatusForm = this.createSellerStatusFormGroup();

    this.sellerDropDown = [];
    this.creationService.getSellers().subscribe(
      result => {
        this.sellersList = result;

        this.sellersList.forEach(value => {
          this.sellerDropDown.push({
            label: value.sellerName,
            value :value.sellerId
          })
        })

      }
    );

  }

  UpdateSellerStatus(){
    this.updateSellerStatusError = false;
    this.updateSellerStatusSuccess = false;

    if(this.changeSellerStatusForm.valid){
      this.showError = false;
      let sellerId = this.changeSellerStatusForm.get("sellerId")?.value;
      let sellerStatus : boolean = true;
      this.sellersList.forEach(data => {
        if(data.sellerId == sellerId){
          sellerStatus = data.sellerActive;
        }
      });
      let st: number = (sellerStatus == true)? 0 : 1;
      this.creationService.updateSellerStatus(sellerId, st).subscribe(
        res => {
          if(res.response == "Seller Status updated successfully"){
            this.updateSellerStatusError = false;
            this.updateSellerStatusSuccess = true;
          }
          else{
            this.updateSellerStatusError = true;
            this.updateSellerStatusSuccess = false;
          }
          console.log(res);
        }
      );
    }
    else{
      this.showError = true;
    }
  }

  login(){
    this.showLoginError = false;
    if(this.loginForm.valid){
      this.showError = false;
      let body = new User();

      body.userName= this.loginForm?.get("userName")?.value;
      body.password = this.loginForm?.get("password")?.value;
  
      this.creationService.login(body).subscribe(
        result => {
          let res = result;
          if(res){
            this.showLoginError = false;
            this.currentUser = res;
            this.loginsuccessful = true;
            this.getVehiclesData();
          }
          else{
            this.showLoginError = true;
          }
        }
      );
    }
    else{
      this.showError = true;
    }
  }

  getVehiclesData(){
    this.creationService.getVehiclesDataForUserId(this.currentUser.userId).subscribe(result=>{
      this.currentUserVehicles = result;

      this.currentUserAuctionVehicles = [];
      this.currentUserDirectVehicles = [];
      
      this.currentUserVehicles.forEach(data => {
        if(data.auctionOrDirect == true){
          this.currentUserAuctionVehicles.push(data);
        }
        else{
          this.currentUserDirectVehicles.push(data);
        }
      })
    })
  }

  openvehicleForm(){
    this.createVehicle = true;
    this.showFailureMessage = false;
    this.showSuccessMessage = false;
    this.vehicleForm = this.createVehicleFormGroup();

  }

  closeAddVehicleForm(){
    this.showFailureMessage = false;
    this.showSuccessMessage = false;
    this.createVehicle = false;
    this.showError = false;
  }

  onSelectAuctionOrDirect(){
    if(this.vehicleForm?.get("isAuction")?.value == "Yes"){
      this.showAuctionFields = true;
    }
    else{
      this.showAuctionFields = false;
    }
  }

  addVehicleData(){
    let body = new vehicleDTO();

    this.showFailureMessage = false;
    this.showSuccessMessage = false;
    if(this.vehicleForm.valid){
      this.showError = false;

      body.userId = this.currentUser.userId;
      body.vin = this.vehicleForm?.get("vin")?.value;
      body.modelName = this.vehicleForm?.get("modelName")?.value;
      body.vehicleCompany = this.vehicleForm?.get("vehicleCompany")?.value;
      body.auctionOrDirect = this.vehicleForm?.get("isAuction")?.value == 'Yes' ? true: false;
      if(body.auctionOrDirect == true){
        body.auctionDate = this.vehicleForm?.get("auctionDate")?.value;
        body.basePrice = this.vehicleForm?.get("basePrice")?.value;
      }
      else{
        body.price = this.vehicleForm?.get("price")?.value;
      }
  
      this.creationService.addVehicle(body).subscribe(
        result => {
          if(result.response == "Added Succesfully")
          {
            this.showSuccessMessage = true;
            this.showFailureMessage = false;
            this.createVehicle = false;
            this.getVehiclesData();
          }
          else{
            this.showSuccessMessage = false;
            this.showFailureMessage = true;
          }
          
        }
      );
    }
    else{
      this.showError = true;
    }
  }

}
