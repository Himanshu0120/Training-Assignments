const chose=document.querySelector(".chose")
const login=document.querySelector(".login")
const signup=document.querySelector(".signup")

// chose.style.display="none"

document.querySelector("#log").addEventListener('click',(e)=>{
    login.style.display="block"
    
    chose.style.display="none"
    signup.style.display="none"
    
})
document.querySelector("#sign").addEventListener('click',(e)=>{
    
   
    chose.style.display="none"
    signup.style.display="block"
    
})