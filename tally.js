   class Scores {
      constructor() {
         this.collection = [];
         this.scores = [];
      }

      add(letter, score) {
         this.collection.push(letter);
         this.scores.push({
            letter: letter,
            scr: score
         });
      }

      contain(letter) {
            return this.collection.includes(letter.toLowerCase());
      }

      logInOrder() {
         this.scores.sort(function (a, b) {
            return b.scr - a.scr;
         });
         for (let i = 0; i < this.scores.length; i++)
            console.log(this.scores[i].letter, ": ", this.scores[i].scr);
      }
   }

   function tally(str) {
      let knowns = new Scores();

      for (letter of str) {
         let low = letter.toLowerCase();
         let up = letter.toUpperCase();

         if (!knowns.contain(low)) {
            cntLower = (str.match(new RegExp(low, "g")) || []).length;
            cntUpper = (str.match(new RegExp(up, "g")) || []).length;
            knowns.add(low, cntLower - cntUpper);
         }
      }
      knowns.logInOrder();
   }

   tally("EbAAdbBEaBaaBBdAccbeebaec");
