function calcx()
{
    function mySelect() {
        if (!!s1.selectedIndex && !!s2.selectedIndex) {
            t.rows [s2.selectedIndex].cells [s1.selectedIndex].style.backgroundColor = 'lime';
            r.innerHTML = t.rows [s2.selectedIndex].cells [s1.selectedIndex].innerHTML;
        }
    }

    let t = document.getElementById ('tbl');
    let r = document.getElementById ('result');
    let s1 = document.getElementById ('first');
    let s2 = document.getElementById ('second');

    for (let  j = 1; j < t.rows [0].cells.length; j++)
    {
        let op = document.createElement ('option');
        op.text = t.rows [0].cells [j].innerHTML;
        s1.options.add (op);
    }

    for (let  j = 1; j < t.rows.length; j++)
    {
        let op = document.createElement ('option');
        op.text = t.rows [j].cells [0].innerHTML;
        s2.options.add (op);
    }

    s1.onchange = mySelect;
    s2.onchange = mySelect;
}

function raschitat() {
    // calcx();
    let dlinasten = document.getElementById('dlinasten').value;
    let visotasten  = document.getElementById('visotasten').value;
    let shirinaokna  = document.getElementById('shirinaokna').value;
    let visotaokna  = document.getElementById('visotaokna').value;
    let vsegookon  = document.getElementById('vsegookon').value;
    let shirinadveri  = document.getElementById('shirinadveri').value;
    let visotadveri  = document.getElementById('visotadveri').value;
    let vsegodverei  = document.getElementById('vsegodverei').value;
    let result  = document.getElementById('result').textContent;
    {
        let ploschadsten = parseFloat (dlinasten) * parseFloat (visotasten);
        document.getElementById('ploschadsten').innerHTML = "Площадь стен равна: "+ ploschadsten +" м2";
        let ploshadproemov = parseFloat (shirinaokna)* parseFloat (visotaokna)* parseFloat (vsegookon)+ parseFloat (shirinadveri)* parseFloat (visotadveri)* parseFloat (vsegodverei);
        document.getElementById('ploshadproemov').innerHTML = "Площадь проемов равна: "+ ploshadproemov +" м2";
        let vsegokirpichei = Math.ceil((ploschadsten - ploshadproemov) * parseFloat (result));
        document.getElementById('vsegokirpichei').innerHTML = "Итого потребуется: <b>"+ vsegokirpichei +" шт. <b>";
    }
}