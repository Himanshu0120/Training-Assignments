// Student 
class Student{
    constructor(name,email,website,gender,skills,img){
        this.name=name;
        this.email=email;
        this.website=website;
        this.img=img;
        this.gender=gender;
        this.skills=skills;
    }
}

// class for all UI related functions
class UI{
    // Function to display  all the students
    static displayStudents(){
        let students=Storage.getStudents();
        students.forEach(student=>UI.addStudent(student));
    }

    // Function to remove all Students from UI
    static removeAll(){
        let table=document.getElementById("tbody");
        table.innerHTML="";
    }

    // Add a student to Table
    static addStudent(student){
        let table=document.getElementById("tbody");
        const row=document.createElement('tr');
        row.classList.add('fade');
        let skills="";
        student.skills.forEach(skill=>skills=skills+skill+"    ");
        row.innerHTML=`<td>
                <h6>${student.name}</h6>
                <p>${student.gender}</p>
                <br>
                <p>${student.email}</p>
                <br>
                <p><a href=${student.website} target="blank">Website</a></p>
                <br>
                <p>${skills}</p></td>
        `;
        row.innerHTML=row.innerHTML+`<td><img src=${student.img} alt=""></td>`;
        table.appendChild(row);
        setTimeout(()=>{
            row.classList.remove("fade");
        },1000)
        
    } 

    // Funtion to clear fields after each submission
    static clearFields(){
        document.querySelector("#NameInput").value="";
        document.querySelector("#EmailInput").value="";
        document.querySelector("#WebsiteInput").value="";
        document.querySelector("#ImageInput").value="";
        document.getElementsByName("gender").forEach(radio=>{
            if(radio.checked){
                radio.checked=false;
               
            }
         })
         document.getElementsByName("skills").forEach(check=>{
            if(check.checked){
                check.checked=false;
            }
        })
    }

    // Funvtion for showing alerts
    static ShowAlert(message,className){
        const div=document.createElement('div');
        div.className=`alert alert-${className} mt-5`;
        div.appendChild(document.createTextNode(message));
        document.querySelector('.alertArea').appendChild(div);
        setTimeout(()=>document.querySelector(".alert").remove(),3000)
    }
}

// class for all Locakstorage related functions
class Storage{
    // Function to return student list from local storage
    static getStudents(){
        let students;
        if(localStorage.getItem("students")===null){
            students=[];
        }
        else{
            students=JSON.parse(localStorage.getItem("students"));
        }
        return students;
    }

    // Add a student to local storage
    static addStudent(student){
        let students=Storage.getStudents();
        students.push(student);
        localStorage.setItem('students',JSON.stringify(students));
    }

    // Remove all students from local storage
    static removeAll(){
        let students=[];
        localStorage.setItem('students',JSON.stringify(students));
    }

    // Finction to chceck if the Id already exists in the storage
    static checkId(student){
        let students=Storage.getStudents();
        let result=false;
        students.forEach(item=>{
            if(item.email===student.email)
            
            result=true;
        })
        
        return result;
    }
}


form=document.querySelector("#form");

// Enroll eventListener
form.addEventListener("submit",(e)=>{
    e.preventDefault();

    // Getting all the inputs
    name=document.querySelector("#NameInput").value;
    email=document.querySelector("#EmailInput").value;
    website=document.querySelector("#WebsiteInput").value;
    img=document.querySelector("#ImageInput").value;
    let gender;
    document.getElementsByName("gender").forEach(radio=>{
       if(radio.checked){
           gender=radio.value
          
       }
    })
    skills=[]
    document.getElementsByName("skills").forEach(check=>{
        if(check.checked){
            skills.push(check.value)
        }
    })
    // Checking skills input
    if(skills.length===0){
        UI.ShowAlert("Select at least one skill",'primary');
        return;
    }

    // Adding the info to new object
    const student=new Student(name,email,website,gender,skills,img);
    
    //  Checking for duplicate emailId
    if(Storage.checkId(student)){
        UI.ShowAlert("Email already exists",'primary');
        return;
    }

    // Name validation if input is null or Spaces
    if (!student.name.replace(/\s/g, '').length) {
        UI.ShowAlert("Name cannot be null",'primary');
        return;
    }
    // Email validation if input only contains non alphabets 
    var name = student.email.substring(0, email.lastIndexOf("@"));
    if(name.replace(/[^a-zA-Z]+/g, '').length===0){
        UI.ShowAlert("Email Should Contain ALphabets",'primary');
        return;
    };
    

    // Adding enrolled student to local storage
    Storage.addStudent(student);

    // Display the added student
    UI.addStudent(student);
    //  Clear the inout fields after submit
    UI.clearFields();
    UI.ShowAlert("Student Added",'success')
    
})



// Event Listener for Clear All button
document.getElementById("clear").addEventListener("click",()=>{
    console.log("hi");
    Storage.removeAll();
    UI.removeAll();
    UI.ShowAlert("Removed All Students",'danger')
})


// Event Listener for diaplaying all students when page loads
window.addEventListener("load",UI.displayStudents);

// Event listener for clear fields button
document.getElementById("clearFields").addEventListener('click',(e)=>UI.clearFields())