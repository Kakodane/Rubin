package enums;

public enum Uloga {
    ADMINISTRATOR {
        public String toString() {
            return "Administrator";
        }
    },
    MODERATOR {
        public String toString() {
            return "Moderator";
        }
    },
    ULOGOVANKORISNIK {
        public String toString() {
            return "Ulogovan korisnik";
        }
    },
    KOMPANIJA {
        public String toString() {
            return "Kompanija";
        }
    }
}
