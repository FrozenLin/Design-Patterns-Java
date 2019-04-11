package ObserverPattern;

interface SubjectInterface {
    void register(Observer anObserver);

    void unregister(Observer anObserver);

    void notifyRegisteredUsers(int notifiedValue);
}
