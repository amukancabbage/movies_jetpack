package com.example.moviesjetpack.utils

import com.example.moviesjetpack.model.MoviesEntity
import com.example.moviesjetpack.model.TvEntity

object DataDummy {

    fun generateDummyMovies(): ArrayList<MoviesEntity> {

        val movies = ArrayList<MoviesEntity>()

        movies.add(MoviesEntity("532170",
            "Farmlands",
            "A detailing of the plight of white South African farmers.",
            "2019-11-01",
            "https://image.tmdb.org/t/p/w500/1jNS4DoNh7aalZrLioa7BVjoZna.jpg",
            "https://image.tmdb.org/t/p/w500/xUeDT0xcBMK81xfwj4MTrMEbNLQ.jpg","6.2"
        ))
        movies.add(MoviesEntity("17532",
            "S. Darko",
            "S. Darko follows Samantha Darko, the younger sister of Donnie, the protagonist of Donnie Darko, and her friend Corey. On their way to California, their car breaks down, forcing them to wait in a small town until it is fixed. While there, Samantha begins to have dreams that warn her of the end of the universe.",
            "2009-04-28",
            "https://image.tmdb.org/t/p/w500/dAol6pkKEX7zM1rICqPgUWmas2S.jpg",
            "https://image.tmdb.org/t/p/w500/scVLRx5GWyznYoBMUo8aXxgLot9.jpg","3.9"
        ))
        movies.add(MoviesEntity("13492",
            "Frontier(s)",
            "A gang of young thieves flee Paris during the violent aftermath of a political election, only to hole up at an Inn run by neo-Nazis.",
            "2007-07-01",
            "https://image.tmdb.org/t/p/w500/lX5XyaUQ4yXRY1knq5N8IKj6Ua4.jpg",
            "https://image.tmdb.org/t/p/w500/797NHoM5WWad5h0gw8ipVFM6YRs.jpg","6.1"
        ))
        movies.add(MoviesEntity("84348",
            "V/H/S/2",
            "When a group of misfits is hired by an unknown third party to burglarize a desolate house and acquire a rare VHS tape, they discover more found footage than they bargained for.",
            "2019-11-01",
            "https://image.tmdb.org/t/p/w500/yo49x6Jhr1ecCjy1ByFqwAbtARJ.jpg",
            "https://image.tmdb.org/t/p/w500/xAC9kXLxUHpdCkISgYcLzYrxIQR.jpg","5.9"
        ))
        movies.add(MoviesEntity("3133",
            "Badlands",
            "Dramatization of the Starkweather-Fugate killing spree of the 1950s, in which a teenage girl and her twenty-something boyfriend slaughtered her entire family and several others in the Dakota badlands.",
            "1973-10-15",
            "https://image.tmdb.org/t/p/w500/yAFn7Bc80pF98DOxRs85d78jWbD.jpg",
            "https://image.tmdb.org/t/p/w500/czf6PpgXD71D0OAbyAdVXK0PEQj.jpg","7.6"
        ))
        movies.add(MoviesEntity("85224",
            "Gas-s-s-s!",
            "A gas is let loose upon the world that kills anyone over 25 years old.",
            "1970-09-04",
            "https://image.tmdb.org/t/p/w500/g8GZW491qCPHm8jpL0ae14zpdtn.jpg",
            "https://image.tmdb.org/t/p/w500/lNswxUchbuUV0C0NgvxfRRldQGC.jpg","5"
        ))
        movies.add(MoviesEntity("335578",
            "Land of Mine",
            "In the days following the surrender of Germany in May 1945, a group of young German prisoners of war is handed over to the Danish authorities and subsequently sent to the West Coast, where they are ordered to remove the more than two million mines that the Germans had placed in the sand along the coast. With their bare hands, crawling around in the sand, the boys are forced to perform the dangerous work under the leadership of a Danish sergeant.",
            "2015-12-03",
            "https://image.tmdb.org/t/p/w500/7TOYH2VDnYbXpBKlrkdQZUSC3Du.jpg",
            "https://image.tmdb.org/t/p/w500/vkzeh2G7Gwapo4J1eqGWRph2hCs.jpg","7.8"
        ))
        movies.add(MoviesEntity("426265",
            "Burning Sands",
            "Deep into Hell Week, a favored pledgee is torn between honoring his code of silence or standing up against the intensifying violence of underground hazing.",
            "2017-01-24",
            "https://image.tmdb.org/t/p/w500/nTOithYdgE4jAdSIuH1nAaxkmzY.jpg",
            "https://image.tmdb.org/t/p/w500/ieaqmpp6W8UGdvTVclBrQctLrgM.jpg","6.2"
        ))
        movies.add(MoviesEntity("424",
            "Schindler's List",
            "The true story of how businessman Oskar Schindler saved over a thousand Jewish lives from the Nazis while they worked as slaves in his factory during World War II.",
            "1993-11-30",
            "https://image.tmdb.org/t/p/w500/yPisjyLweCl1tbgwgtzBCNCBle.jpg",
            "https://image.tmdb.org/t/p/w500/cTNYRUTXkBgPH3wP3kmPUB5U6dA.jpg","8.6"
        ))
        movies.add(MoviesEntity("19380",
            "White Sands",
            "A small southwestern town sheriff finds a body in the desert with a suitcase and $500,000. He impersonates the man and stumbles into an FBI investigation.",
            "1992-04-24",
            "https://image.tmdb.org/t/p/w500/7XderqM5oxzbWanJq6FLvpmFLdA.jpg",
            "https://image.tmdb.org/t/p/w500/3Y5rAC3q3U0auyvSGxtNdtxSwGU.jpg","5.7"
        ))
        movies.add(MoviesEntity("625719",
            "Martin's Close",
            "Part of the long running tradition of 'A Ghost Story For Christmas' on BBC Four in the UK, and the third instalment presented by Mark Gatiss. A young squire accused of murdering a young girl that did not return his feelings of love reveals a supernatural secret at his trial.",
            "2019-12-24",
            "https://image.tmdb.org/t/p/w500/ArhYVKnfILuWERuUyuvWJd1jqRm.jpg",
            "https://image.tmdb.org/t/p/w500/gcccicGB2eKpE8K50wGXa9GJY3M.jpg","3"
        ))


        return movies
    }

    fun generateDummyTvs(): List<TvEntity> {

        val tvs = ArrayList<TvEntity>()

        tvs.add(TvEntity("57243",
            "Doctor Who",
            "The Doctor is a Time Lord: a 900 year old alien with 2 hearts, part of a gifted civilization who mastered time travel. The Doctor saves planets for a living—more of a hobby actually, and the Doctor's very, very good at it.",
            "2005-03-26",
            "https://image.tmdb.org/t/p/w500/cDDb7WA2i7cENhkEEjXEDrXGyNL.jpg",
            "https://image.tmdb.org/t/p/w500/nfH8SZJVOxcBlFaqqtoqS5hHizG.jpg","7"
        ))

        tvs.add(TvEntity("4656",
            "WWE Raw",
            "WWE Raw is a professional wrestling television program that currently airs live on Monday evenings on the USA Network in the United States. The show debuted on January 11, 1993. WWE Raw moved from the USA Network to TNN in September, 2000 and then to Spike TV in August, 2003 when TNN was rebranded. On October 3, 2005 WWE Raw returned to the USA Network.\n\nSince its first episode, WWE Raw has broadcast live from 203 different arenas in 169 cities and towns in ten different nations. As of the show's 1,000th episode, airing on July 23, 2012, WWE Raw has become a three-hour broadcast from two-hours, a format that had previously been reserved for special episodes.",
            "1993-01-11",
            "https://image.tmdb.org/t/p/w500/qvQ2Fu75bNUiZ1yzuHI3wkTGy7C.jpg",
            "https://image.tmdb.org/t/p/w500/l6ci9v4XC6DCTlZG8NiufRBx3kG.jpg","6.4"
        ))

        tvs.add(TvEntity("45",
            "Top Gear",
            "The hosts talk about the latest cars and its specifications. They review the performance of the car and also find out if it is as good as the manufacturers claim. The current hosts are Chris Evans and Matt LeBlanc with The Stig.",
            "2002-10-20",
            "https://image.tmdb.org/t/p/w500/aqM6QnuhSXzjHlKbXyKUqxaGiWu.jpg",
            "https://image.tmdb.org/t/p/w500/o8IhJLFGLhqhpgKf68bvts12f5Y.jpg","7.4"
        ))


        tvs.add(TvEntity("84661",
            "The Outsider",
            "When an insidious supernatural force edges its way into a seemingly straightforward investigation into the gruesome murder of a young boy, it leads a seasoned cop and an unorthodox investigator to question everything they believe in.",
            "2020-01-12",
            "https://image.tmdb.org/t/p/w500/aMiPwPQjQI1EZN3xP2V0sSU37dc.jpg",
            "https://image.tmdb.org/t/p/w500/lmlsqpAfDZnZumcFhbsTrOy9uNZ.jpg","8.3"
        ))

        tvs.add(TvEntity("37854",
            "One Piece",
            "Years ago, the fearsome pirate king Gol D. Roger was executed, leaving a huge pile of treasure and the famous \"One Piece\" behind. Whoever claims the \"One Piece\" will be named the new pirate king. Monkey D. Luffy, a boy who consumed one of the \"Devil's Fruits\", has it in his head that he'll follow in the footsteps of his idol, the pirate Shanks, and find the One Piece. It helps, of course, that his body has the properties of rubber and he's surrounded by a bevy of skilled fighters and thieves to help him along the way. Monkey D. Luffy brings a bunch of his crew followed by, Roronoa Zoro, Nami, Usopp, Sanji, Tony-Tony Chopper, Nico Robin, Franky, and Brook. They will do anything to get the One Piece and become King of the Pirates!",
            "1999-10-20",
            "https://image.tmdb.org/t/p/w500/335fmCjQq4jRZK2QR3ZVJ84yYO0.jpg",
            "https://image.tmdb.org/t/p/w500/4Mt7WHox67uJ1yErwTBFcV8KWgG.jpg","7.8"
        ))

        tvs.add(TvEntity("2661",
            "Kamen Rider",
            "A Japanese anthology series centered around a man who transforms into a bug-themed superhero.",
            "1971-04-03",
            "https://image.tmdb.org/t/p/w500/o57T19zgZakEpre3d9ddy1UZonp.jpg",
            "https://image.tmdb.org/t/p/w500/A6euKtibc99zyWNy3TPbXA31h1l.jpg","5.8"
        ))

        tvs.add(TvEntity("4546",
            "Curb Your Enthusiasm",
            "The off-kilter, unscripted comic vision of Larry David, who plays himself in a parallel universe in which he can't seem to do anything right, and, by his standards, neither can anyone else.",
            "2000-10-15",
            "https://image.tmdb.org/t/p/w500/kWQDOnLs5DK0ta8xQZLsaienIHp.jpg",
            "https://image.tmdb.org/t/p/w500/eNSIkGIYqXVFNmT85P4X7BsXkYI.jpg","8.1"
        ))

        tvs.add(TvEntity("6390",
            "Escape to the Country",
            "The property show that helps prospective buyers find their dream home in the country.",
            "2002-10-14",
            "https://image.tmdb.org/t/p/w500/ykSfW3rU7Th0VvrgB85nHvQZCAN.jpg",
            "https://image.tmdb.org/t/p/w500/w7oNyGaZ8Tz9LnAr0nf6dvKC968.jpg","6.7"
        ))

        tvs.add(TvEntity("71663",
            "Black Lightning",
            "Jefferson Pierce is a man wrestling with a secret. As the father of two daughters and principal of a charter high school that also serves as a safe haven for young people in a New Orleans neighborhood overrun by gang violence, he is a hero to his community.",
            "2018-01-16",
            "https://image.tmdb.org/t/p/w500/90QFKG1QK7szgMIB2SxFADY1pvy.jpg",
            "https://image.tmdb.org/t/p/w500/h6QhUjIquntBfvD8nm71RoEgwvr.jpg","6.7"
        ))

        tvs.add(TvEntity("82395",
            "The Liar",
            "",
            "2012-01-08",
            "https://image.tmdb.org/t/p/w500/cE3EvYf87nM6B9ZKp4w9sTz6QCY.jpg",
            "https://image.tmdb.org/t/p/w500/kvdRZOLuvln0YSrc01JmugXxYaB.jpg","0"
        ))

        tvs.add(TvEntity("90811",
            "Avenue 5",
            "40 years in the future, space captain Ryan Clark and the crew of the luxury space cruise ship Avenue 5 navigate disgruntled passengers and unexpected events after experiencing technical difficulties onboard.",
            "2020-01-19",
            "https://image.tmdb.org/t/p/w500/tJuFDbd6OmqEcfWbCDSYIHlqGoN.jpg",
            "https://image.tmdb.org/t/p/w500/8Q1jEFvhGNQqDUzEuqj9G9tAJYL.jpg","6.4"
        ))

        return tvs
    }
}