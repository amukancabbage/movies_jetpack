package com.example.moviesjetpack.utils

import com.example.moviesjetpack.data.MoviesEntity


class DataDummy {
    companion object {
        fun generateDummyMovies(): ArrayList<MoviesEntity> {
            var movies = ArrayList<MoviesEntity>()

            movies.add(
                MoviesEntity(
                    "m1",
                    "Menjadi Android Developer Expert",
                    "Dicoding sebagai satu-satunya Google Authorized Training Partner di Indonesia telah melalui proses penyusunan kurikulum secara komprehensif. Semua modul telah diverifikasi langsung oleh Google untuk memastikan bahwa materi yang diajarkan relevan dan sesuai dengan kebutuhan industri digital saat ini. Peserta akan belajar membangun aplikasi Android dengan materi Testing, Debugging, Application, Application UX, Fundamental Application Components, Persistent Data Storage, dan Enhanced System Integration.",
                    "100 Hari",
                    "https://www.dicoding.com/images/small/academy/menjadi_android_developer_expert_logo_070119140352.jpg"
                )
            )
            movies.add(
                MoviesEntity(
                    "m2",
                    " Kotlin Android Developer Expert",
                    "Dicoding sebagai satu-satunya Google Authorized Training Partner di Indonesia telah melalui proses penyusunan kurikulum secara komprehensif. Semua modul telah diverifikasi langsung oleh Google untuk memastikan bahwa materi yang diajarkan relevan dan sesuai dengan kebutuhan industri digital saat ini. Peserta akan belajar membangun aplikasi Android dengan materi Testing, Debugging, Application, Application UX, Fundamental Application Components, Persistent Data Storage, dan Enhanced System Integration.",
                    "100 Hari",
                    "https://www.dicoding.com/images/small/academy/menjadi_android_developer_expert_logo_070119140352.jpg"
                )
            )
            return movies
        }
    }
}