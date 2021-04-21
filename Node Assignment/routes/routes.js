const express=require("express");
const sql =require("mysql");
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

    
const router=express.Router();
router.get("/",(req,res)=>{
    
    res.send("In blogs")
});
router.get("/new",(req,res)=>{
    res.render("newPost")
})

router.post("/save",(req,res)=>{
    let title=req.body.title;
    let content=req.body.content;
    connection.query(`INSERT INTO blogs(title,content) VALUES ("${title}","${content}");`, (err, rows, fields) => {
        if (!err)
        console.log(rows);
        else
        console.log(err);
        res.redirect("/")
        })
        
})

router.get("/edit/:id",(req,res)=>{
    let id=req.params.id;
    connection.query("select * from blogs where id=?",[id],(err,blog)=>{
        console.log(blog);
        res.render("edit",{blog:blog[0]});
    })
})

router.get("/delete/:id",(req,res)=>{
    let id=req.params.id;
    connection.query("delete from blogs where id=?",[id],(err,result)=>{
        res.redirect("/")
    })
})

router.post("/update/:id",(req,res)=>{
    let id=req.params.id;
    let title=req.body.title;
    console.log(title);
    let content=req.body.content;
    connection.query(`update blogs set title="${title}",content="${content}" where id=${id};`,(err,result)=>{
        if(err)
        console.log(err);
        res.redirect("/")
    })
})

router.get("/read/:id",(req,res)=>{
    let id=req.params.id;
    connection.query("select * from blogs where id=?",[id],(err,blog)=>{
        console.log(blog);
        res.render("read",{blog:blog[0]});
    })
})
module.exports=router;