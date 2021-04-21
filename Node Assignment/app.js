const express=require("express");
const router=require(`./routes/routes`)
const app=express();
const bodyparser=require("body-parser");
const sql=require("mysql");

const connection=sql.createConnection({
    host: "localhost",
    user: "root",
    port: "3306",
    database: "blog",
    password: "root"
})
connection.connect((err)=> {
    if(!err)
    console.log('Connection Established Successfully');
    else
    console.log('Connection Failed!'+ JSON.stringify(err,undefined,2));
    });




app.use(express.static(`${__dirname}/public/`));
app.set("views","./src/views");
app.set("view engine","ejs")
app.use(express.urlencoded({extended:true}));
app.use("/blogs",router);
app.get("/", (req,res)=>{
    connection.query("select * from blogs",(err,blogs)=>{
        if(!err){
            console.log(blogs);
            res.render("index",{blogs:blogs});
        }
        
    });
    // console.log(db);
    
});


let port=process.env.PORT || 4000;
app.listen(port,()=>{
    console.log("listening");
});

let  getPosts=async ()=>{
    connection.query("select * from blogs",(err,rows,fields)=>{
        if(!err){
           return rows;
        }
    })
}