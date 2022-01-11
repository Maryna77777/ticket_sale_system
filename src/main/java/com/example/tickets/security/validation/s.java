//package com.example.tickets.security.validation;
//
//@Service
//public class LoginDetailsServiceImpl implements UserDetailsService, Serializable {
//
//    @Autowired
//    LoginService loginService;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if (username == "" || username.isEmpty()) {
//            throw new UsernameNotFoundException(String.format("User %s is invalid!", username));
//        }
//        Login login = loginService.find(username);
//        if (login == null) {
//            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
//        }
//        if (!loginService.scheduleChecking(login.getScheduled())) {
//            throw new UsernameNotFoundException(String.format("User %s is not authorized this time!", username));
//        }


//public Set<Integer> findDuplicates(List<Integer> listContainingDuplicates)
//        {
//final Set<Integer> setToReturn = new HashSet<>();
//final Set<Integer> set1 = new HashSet<>();
//
//        for (Integer yourInt : listContainingDuplicates)
//        {
//        if (!set1.add(yourInt))
//        {
//        setToReturn.add(yourInt);
//        }
//        }
//        return setToReturn;
//        }


//Нахождение дубликатов
//private <T> Set<T> findDuplicates(Collection<T> collection) {
//
//        Set<T> duplicates = new LinkedHashSet<>();
//        Set<T> uniques = new HashSet<>();
//
//        for(T t : collection) {
//        if(!uniques.add(t)) {
//        duplicates.add(t);
//        }
//        }
//
//        return duplicates;
//        }



//public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public void initialize(UniqueLogin annotation) {
//        // Intentionally empty: nothing to initialize
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext ctx) {
//
//        if (value == null) {
//            return true;
//        }
//
//        boolean loginExists = userService.countByLogin(value) > 0;
//
//        return !loginExists;
//    }
//
//}